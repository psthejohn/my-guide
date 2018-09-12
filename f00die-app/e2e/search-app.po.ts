import { browser, element, by } from 'protractor';

export class NgSearchFoodieAppPage {
  navigateTo() {
    return browser.get('/search');
  }

  getLocationText() {
    return element(by.css('.search_location')).getText();
  }

  getCuisineText() {
    return element(by.css('.search_cuisine')).getText();
  }

  getFirstCardElement() {
    return element(by.css('.card-title'));
  }
  getFavouriteElement() {
    return element(by.css('.favourite'));
  }
  getUnfavouriteElement() {
    return element(by.css('.unfavourite'));
  }
  getSeacrhButtonElementsToClick() {
    return element(by.css('.btn-primary'));
  }
  getDescElement() {
    return element(by.tagName('restaurant-description'));
  }
  getNumberOfRests() {
    return element(by.css('.card-cascade'));
  }
}
