package com.es.k_e_cart_maad.entity;

public class SliderItem{
        public String description;
        public String imageUrl;

    public SliderItem(String description, String imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
}