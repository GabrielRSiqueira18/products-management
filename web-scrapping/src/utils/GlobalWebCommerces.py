# product_name = element.find_element(By.CSS_SELECTOR, "h2[aria-label]").text
# price = element.find_element(By.CLASS_NAME, "a-price-whole").text
# symbol = element.find_element(By.CLASS_NAME, "a-price-symbol").text
# image = element.find_element(By.CLASS_NAME, "s-image").get_attribute("src")
# link = element.find_element(By.CLASS_NAME, "a-link-normal").get_attribute("href")
from enum import Enum



class GlobalWebCommerces:
    class TAG_TYPE(Enum):
        ID = 1
        CLASS = 2
        CSS_SELECTOR = 3

    class ScrappingDetails:
        def __init__(
                self,
                input_tag_type: str,
                input_tag: str,
                submit_button_tag_type: str,
                submit_button_tag: str,
                result_tag_type: str,
                result_tag: str,
                product_name_tag_type: str,
                product_name_tag: str,
                price_tag_type: str,
                price_tag: str,
                symbol_tag_type: str,
                symbol_tag: str,
                image_tag_type: str,
                image_tag: str,
                link_tag_type: str,
                link_tag: str,
        ):
            self.__input_tag_type = input_tag_type
            self.__input_tag = input_tag
            self.__submit_button_tag_type = submit_button_tag_type
            self.__submit_button_tag = submit_button_tag
            self.__result_tag = result_tag
            self.__result_tag_type = result_tag_type
            self.__product_name_tag = product_name_tag
            self.__product_name_tag_type = product_name_tag_type
            self.__price_tag = price_tag
            self.__price_tag_type = price_tag_type
            self.__symbol_tag = symbol_tag
            self.__symbol_tag_type = symbol_tag_type
            self.__image_tag = image_tag
            self.__image_tag_type = image_tag_type
            self.__link_tag = link_tag
            self.__link_tag_type = link_tag_type

        @property
        def input_tag_type(self):
            return self.__input_tag_type

        @property
        def input_tag(self):
            return self.__input_tag

        @property
        def submit_button_tag_type(self):
            return self.__submit_button_tag_type

        @property
        def submit_button_tag(self):
            return self.__submit_button_tag

        @property
        def result_tag(self):
            return self.__result_tag

        @property
        def result_tag_type(self):
            return self.__result_tag_type

        @property
        def product_name_tag(self):
            return self.__product_name_tag

        @property
        def product_name_tag_type(self):
            return self.__product_name_tag_type

        @property
        def price_tag(self):
            return self.__price_tag

        @property
        def price_tag_type(self):
            return self.__price_tag_type

        @property
        def symbol_tag(self):
            return self.__symbol_tag

        @property
        def symbol_tag_type(self):
            return self.__symbol_tag_type

        @property
        def image_tag(self):
            return self.__image_tag

        @property
        def image_tag_type(self):
            return self.__image_tag_type

        @property
        def link_tag(self):
            return self.__link_tag

        @property
        def link_tag_type(self):
            return self.__link_tag_type

    def __init__(
        self,
        name: str,
        url: str,
        scrapping_details: ScrappingDetails,
    ):
        self.__name = name
        self.__url = url
        self.__scrapping_details = scrapping_details

    @property
    def name(self) -> str:
        return self.__name

    @property
    def url(self) -> str:
        return self.__url

    @property
    def scrapping_details(self) -> ScrappingDetails:
        return self.__scrapping_details