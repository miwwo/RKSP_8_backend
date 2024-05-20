package com.project.crud.service;

import com.project.crud.entity.Recipe;
import com.project.crud.entity.ShoppingList;
import com.project.crud.entity.UserEntity;
import com.project.crud.repository.RecipeRepository;
import com.project.crud.repository.ShoppingListRepository;
import com.project.crud.service.interfaces.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingListServiceImpl implements ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    private final RecipeRepository recipeRepository;
    @Override
    public void initializeShoppingList(UserEntity user) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setUser(user);
        shoppingList.setActive(true);
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public ShoppingList getActiveShoppingList(UserEntity user) {
        return shoppingListRepository.findByUserAndActive(user, true);
    }

    @Override
    public ShoppingList addRecipeToShoppingList(UserEntity userEntity, Long recipeId) {
        ShoppingList shoppingList = getActiveShoppingList(userEntity);
        Recipe foundRecipe = recipeRepository.findRecipeById(recipeId);
        if (shoppingList == null || foundRecipe == null) {
            return null;
        }
        shoppingList.getSelectedRecipes().add(foundRecipe);
        return shoppingListRepository.save(shoppingList);
    }

    @Override
    public List<ShoppingList> getAllShoppingLists() {
        return null;
    }

    @Override
    public ShoppingList getShoppingListById(Long id) {
        return null;
    }

    @Override
    public ShoppingList createShoppingList(ShoppingList shoppingList, UserEntity owner) {
        return null;
    }

    @Override
    public ShoppingList updateShoppingList(Long id, ShoppingList shoppingList) {
        return null;
    }

    @Override
    public boolean deleteShoppingList(Long id) {
        return false;
    }
}
