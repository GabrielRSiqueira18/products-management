import json
import logging
import os
import sys
from queue import Queue

from loguru import logger

from utils.global_variables import global_web_commerces
from threads.ScrappingThread import ScrappingThread
from threads.SendThread import SendQueue

def configure_logging():
    logging_folder = "../logs"
    logging_file = "logging.log"

    if not os.path.exists(logging_folder):
        os.makedirs(logging_folder)

    logger.add(
        f"{logging_folder}/{logging_file}",
        rotation="10MB",
        retention="30 days",
        compression="zip",
        level="DEBUG",
        format="{time:YYYY-MM-DD HH:mm:ss} | {level} | {message}",
        enqueue=True
    )

def create_json_results():
    output_dir = "../results"
    output_file = 'products.json'
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    if os.path.isfile(os.path.join(output_dir, output_file)):
        os.remove(os.path.join(output_dir, output_file))

    json_results = {
        "products": [],
    }

    with open(os.path.join(output_dir, output_file), "w", encoding="utf-8") as file:
        json.dump(json_results, file, indent=4, ensure_ascii=False)


if __name__ == '__main__':
    configure_logging()
    logger.info("*******************************************")
    logger.info("    Web Scrapping Application Starting")
    logger.info("*******************************************")
    create_json_results()

    queue_products = Queue(10)

    for web_commerce in global_web_commerces:
        scrapping_thread = ScrappingThread(web_commerce, queue_products)
        scrapping_thread.start()


    send_queue = SendQueue(queue_products)
    send_queue.start()



