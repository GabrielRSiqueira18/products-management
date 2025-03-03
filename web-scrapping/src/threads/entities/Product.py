from datetime import datetime
import pytz

class Product:
    def __init__(self, site, product_name, symbol, price, image_url, site_link):
        self.__site = site
        self.__name = product_name
        self.__symbol = symbol
        self.__price = price
        self.__image_url = image_url
        self.__site_link = site_link
        self.__scrapping_time = datetime.now()

    @property
    def site(self):
        return self.__site

    @property
    def name(self):
        return self.__name

    @property
    def symbol(self):
        return self.__symbol

    @property
    def price(self):
        return self.__price

    @property
    def image_url(self):
        return self.__image_url

    @property
    def site_link(self):
        return self.__site_link

    @property
    def scrapping_time(self):
        return self.__scrapping_time

    def to_dict(self):
        return {
            'site': self.__site,
            'name': self.__name,
            'symbol': self.__symbol,
            'price': self.__price,
            'image_url': self.__image_url,
            'site_link': self.__site_link,
            "scrapping_time": self.scrapping_time.astimezone(pytz.utc).strftime("%Y-%m-%dT%H:%M:%S%z")
        }
