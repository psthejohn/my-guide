import { browser, element, by } from 'protractor';

export class NgFavFoodieAppPage {
  navigateTo() {
    return browser.get('/favourite');
  }

  getHeadingText() {
    return element(by.css('.panel-heading')).getText();
  }

  getCardElements() {
    return element.all(by.css('. card-body'));
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
  getCardElementsToClick() {
    return element(by.css('.card-body'));
  }
  getDescElement() {
    return element(by.tagName('restaurant-description'));
  }

}
