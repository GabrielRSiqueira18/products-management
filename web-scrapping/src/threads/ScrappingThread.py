import random
import threading
import time

from loguru import logger
from utils.global_variables import GlobalWebCommerces, global_web_commerces, QUANTITY_ELEMENTS_PER_SEARCH, TIME_TO_SEARCH_IN_SECONDS
from Selenium import Selenium

class ScrappingThread(threading.Thread):
    def __init__(self, data: GlobalWebCommerces, queue):
        super(ScrappingThread, self).__init__()
        self.__data = data
        self.__name = data.name
        self.__id = data.url
        self.__queue = queue

        self.__products_name_to_search = [
            "computador",
            "mouse",
            "perfume",
            "fone de ouvido"
        ]

    def run(self):
        logger.info("Starting scrapping thread: " + self.__name)

        while True:
            selenium = Selenium(self.__data)
            random_product = self.__products_name_to_search[
                random.randint(0, len(self.__products_name_to_search) - 1)
            ]
            logger.info(f"Try to scrapping product [{self.__name}]: " + random_product)

            result = selenium.search_products(random_product)
            selenium.quit()

            if result is not None:
                self.__queue.put(result)

            time.sleep(5)
