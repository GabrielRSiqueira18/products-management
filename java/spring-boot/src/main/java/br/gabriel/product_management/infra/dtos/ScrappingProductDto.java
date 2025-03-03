package br.gabriel.product_management.infra.dtos;

import br.gabriel.product_management.infra.models.ScrappingProductModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

public record ScrappingProductDto(
    @JsonProperty("name")
    String productName,

    @JsonProperty("site")
    String siteName,

    @JsonProperty("site_link")
    String siteUrl,

    @JsonProperty("symbol")
    String priceSymbol,

    @JsonProperty("price")
    Double productPrice,

    @JsonProperty("image_url")
    String imageUrl,

    @JsonProperty("scrapping_time")
    OffsetDateTime scrappingTime
) {
    public ScrappingProductModel toModel() {
        return new ScrappingProductModel(
            productName,
            siteName,
            priceSymbol,
            productPrice,
            imageUrl,
            siteUrl,
            scrappingTime
        );
    }


}