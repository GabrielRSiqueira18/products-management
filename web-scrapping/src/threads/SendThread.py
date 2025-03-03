import json
import threading
import time

import requests
from loguru import logger


class SendQueue(threading.Thread):
    def __init__(self, queue):
        super(SendQueue, self).__init__()
        self.__queue = queue
        self.__file_path = "../results/products.json"

    def run(self):
        logger.info("Starting thread to send value")

        while True:
            while not self.__queue.empty():
                try:
                    results = self.__queue.get()
                    for result in results:
                        product_name = result.name
                        logger.info(f"Starting to send value: {product_name}")

                        requests.post(
                            "http://localhost:8080/api/v1/web-scrapping",
                            json=result.to_dict(),
                            headers={"Content-Type": "application/json"},
                            verify=False,
                            timeout=5
                        )
                        with open(self.__file_path, 'r+', encoding='utf-8') as file:
                            data = json.load(file)

                            data['products'].append(result.to_dict())

                            file.seek(0)
                            json.dump(data, file, ensure_ascii=False, indent=4)
                            file.truncate()

                except Exception as e:
                    logger.error(f"Error occurred to scrapping a product: {e}")
                    continue
            time.sleep(10)
