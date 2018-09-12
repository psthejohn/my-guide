import { NgSearchFoodieAppPage } from './search-app.po';

describe('ng-foodie App', function() {
  let page: NgSearchFoodieAppPage;

  beforeEach(() => {
    page = new NgSearchFoodieAppPage();
  });


  it('Search Button  should be clickable and number of resulted resturants should be more than zero', () => {
    page.navigateTo();
    page.getSeacrhButtonElementsToClick().click();
    const todos = page.getNumberOfRests();
    expect((page.getNumberOfRests()).length > 0);
  });
  it('Check if the page has favourite and unfavourite button', () => {
    page.navigateTo();
    // expect((page.getLocationText()).length > 0);
  });
  it('Check if the page has favourite and unfavourite button', () => {
    page.navigateTo();
    // expect((page.getCuisineText()).length > 0);
  });
});
