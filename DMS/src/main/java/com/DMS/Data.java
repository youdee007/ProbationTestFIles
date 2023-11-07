package com.DMS;

import java.util.List;
import java.util.Scanner;

public class Data {
		 private ItemManager itemManager;
		 private CategoryManager categoryManager;

		    public Data(ItemManager itemManager, CategoryManager categoryManager) {
		        this.itemManager = itemManager;
		        this.categoryManager = categoryManager;
		    }

		    public static void addCategory() {
		        Scanner sc = new Scanner(System.in);
		        System.out.print("Enter Category Id: ");
		        int id = sc.nextInt();
		        System.out.print("Enter Category name: ");
		        String name = sc.next();

		        Category category = new Category(id, name);
		        CategoryManager.addCategories(category);
		        System.out.println("Category added successfully.");
		    }

		    public static void listCategory() {
		        List<Category> category = CategoryManager.getAllCategory();
		        if (category.isEmpty()) {
		            System.out.println("No Categories found.");
		        } else {
		            System.out.println("List of Categories:");
		            for (Category categoryies : category) {
		                System.out.println("ID: " + categoryies.getId() + ", Name: " + categoryies.getName());
		            }
		        }
		    }
		    
		    public static void addItem() {
		        Scanner sc = new Scanner(System.in);
		        System.out.print("Enter Item Id:");
		        int id = sc.nextInt();
		        System.out.print("Enter Item name:");
		        String name = sc.next();
		        System.out.print("Enter Description:");
		        String desc = sc.next();
		        System.out.print("Enter Category Id:");
		        int catId = sc.nextInt();

		        Item item = new Item(id, name, desc, catId);
		        ItemManager.addItems(item);
		        System.out.println("Items added successfully.");
		    }

		    public static void listItem() {
		        List<Item> item = ItemManager.getAllItems();
		        if (item.isEmpty()) {
		            System.out.println("No Items found.");
		        } else {
		            System.out.println("List of Items:");
		            for (Item items : item) {
		                System.out.println("ID: " + items.getId() + ", Name: " + items.getName() + ", Description" + items.getDescription() + ", Category ID" + items.getCategoryId());
		            }
		        }
		    }

}
