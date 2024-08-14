package org.lld.factory;

import org.lld.enums.SearchParam;
import org.lld.strategy.ISearchRestaurant;
import org.lld.strategy.SearchRestaurantByLocation;
import org.lld.strategy.SearchRestaurantByPrice;

public class SearchStrategyFactory {

    SearchRestaurantByPrice searchRestaurantByPrice;
    SearchRestaurantByLocation searchRestaurantByLocation;
    public SearchStrategyFactory() {
        searchRestaurantByPrice = new SearchRestaurantByPrice();
        searchRestaurantByLocation = new SearchRestaurantByLocation();
    }

    public ISearchRestaurant getRestaurantSearchStrategy(String searchParam) {
        SearchParam searchStrategy = SearchParam.valueOf(searchParam);
        if (SearchParam.LOCATION == searchStrategy) {
            return searchRestaurantByLocation;
        } else if (SearchParam.PRICE == searchStrategy) {
            return searchRestaurantByPrice;
        } else {
            return searchRestaurantByPrice;
        }
    }
}
