import { NgFoodieAppPage } from './app.po';

describe('ng-foodie App', function() {
  let page: NgFoodieAppPage;

  beforeEach(() => {
    page = new NgFoodieAppPage();
  });

   it('should display heading saying Restaurants Near You', () => {
     page.navigateTo();
     expect(page.getHeadingText()).toEqual('Restaurants Near You');
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
    // expect(page.getDescElement()).toContain('Your Reviews');
  });
});
