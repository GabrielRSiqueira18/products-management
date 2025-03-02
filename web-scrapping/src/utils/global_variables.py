from selenium.webdriver.common.by import By

from .GlobalWebCommerces import GlobalWebCommerces

global_web_commerces: list[GlobalWebCommerces] = [
    GlobalWebCommerces(
        "mercado_livre",
        "https://www.mercadolivre.com.br",
        GlobalWebCommerces.ScrappingDetails(
            By.CLASS_NAME,
            "nav-search-input",
            By.CLASS_NAME,
            "nav-search-btn",
            By.CLASS_NAME,
            "ui-search-layout__item",
            By.CLASS_NAME,
            "poly-component__title",
            By.CLASS_NAME,
            "andes-money-amount__fraction",
            By.CLASS_NAME,
            "andes-money-amount__currency-symbol",
            By.CLASS_NAME,
            "poly-component__picture",
            By.CLASS_NAME,
            "poly-component__title"
        )

    ),

    GlobalWebCommerces(
        "amazon",
        "https://www.amazon.com.br",
        GlobalWebCommerces.ScrappingDetails(
            By.ID,
            "twotabsearchtextbox",
            By.ID,
            "nav-search-submit-button",
            By.CSS_SELECTOR,
            '[data-component-type="s-search-result"]',
            By.CSS_SELECTOR,
            "h2[aria-label]",
            By.CLASS_NAME,
            "a-price-whole",
            By.CLASS_NAME,
            "a-price-symbol",
            By.CLASS_NAME,
            "s-image",
            By.CLASS_NAME,
            "a-link-normal"
        )
    ),
]

QUANTITY_ELEMENTS_PER_SEARCH = 10
TIME_TO_SEARCH_IN_SECONDS = 1000 * 60 * 60 * 6 # 6 Horas

