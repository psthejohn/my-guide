package com.stackroute.foodieapi.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.stackroute.foodieapi.dao.impl.FavouritesDAOImpl;
import com.stackroute.foodieapi.entity.Favourite;
import com.stackroute.foodieapi.service.impl.FavouriteServiceImpl;



@RunWith(PowerMockRunner.class)
@PrepareForTest(FavoritesDaoTest.class)
public class FavoritesDaoTest {
	FavouriteServiceImpl favouriteService;
	EntityManager entityManager;
	 FavouritesDAO favouritesDAO;

	@Mock
	private Query query;
	
	
//	@Mock
//	private FavouritesDAO favouritesDAO;

	

	@Before
    public void before() {
		favouriteService = new FavouriteServiceImpl();

        entityManager = mock(EntityManager.class);
        favouritesDAO=new FavouritesDAOImpl();
    }

    @Test
    public void testGetAllFavourites() {
        
        Query query = mock(Query.class);
        when(entityManager.createQuery("FROM Favourite")).thenReturn(query);
        
        List<Favourite> favList = new ArrayList<>();
        when(query.getResultList()).thenReturn(favList);

//        
//        List<Favourite> result = favouriteService.getAllFavourites();
//
//        verify(query).getResultList();
//        assertSame(favList, result);

    }
	
	
}
