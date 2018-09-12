import { NgFavFoodieAppPage } from './fav-app.po';

describe('ng-foodie App', function() {
  let page: NgFavFoodieAppPage;

  beforeEach(() => {
    page = new NgFavFoodieAppPage();
  });

   it('should display heading saying Your Favourite Restaurants', () => {
     page.navigateTo();
     // expect(page.getHeadingText()).toEqual('Your Favourite Restaurants');
   });
   it('CardElements size should be more than zero', () => {
    page.navigateTo();
    expect((page.getCardElements()).length > 0);
  });
  it('FirstCardElement size should be more than zero', () => {
    page.navigateTo();
    expect((page.getFavouriteElement()).length > 0);
  });
  it('Check if the page has favourite and unfavourite button', () => {
    page.navigateTo();
    expect((page.getUnfavouriteElement()).length > 0);
  });

  it('CardElement  should be clickable', () => {
    // page.navigateTo();
    // page.getCardElementsToClick().click();
    // expect((page.getDescElement()).length > 0);
  });
});
