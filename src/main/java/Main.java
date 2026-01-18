import jakarta.persistence.*;
import model.Category;
import model.Option;
import model.Product;
import model.Value;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Hibernate :
        //- EntityManager аналог -JdbcTemplate
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        Scanner scanner = new Scanner(System.in);

//        System.out.println(entityManager.isOpen());
        //JPA
        //ModelClasses is important
//        Category category=entityManager.find(Category.class,5);
//        System.out.println(category.getName());

        ////получение списка объектов
        //jpql
        //select c Category с нужно писать название класса а не таблицы
//        Query query=entityManager.createQuery("select c from Category c");
//        List<Object> list=query.getResultList();
//        TypedQuery<Category> query= entityManager.createQuery("select c from Category c",Category.class);
//       List<Category> list=query.getResultList();
//        for (Category category:list){
//            System.out.println(category.getId()+"."+category.getName());
//    }
//        TypedQuery<Category> query = entityManager.createQuery("select c from Category c where name=?1", Category.class);
//        Category category = entityManager.createQuery("select c from Category c where c.name=:categoryName", Category.class)
//                .setParameter("categoryName", "Процессоры").getSingleResult();
//        System.out.println(category.getId() + "." + category.getName());

//        Scanner scanner=new Scanner(System.in);
//        System.out.println("введите начальный диапозон");
//        long start=scanner.nextLong();
//        System.out.println("введите конечный диапозон");
//        long end = scanner.nextLong();
//        List<Product> products=entityManager.createQuery("select p from Product p where price between ?1 and ?2",Product.class)
//                .setParameter(1,start)
//                .setParameter(2,end)
//                .getResultList();
//        for(Product product:products){
//            System.out.println(product.getName()+":"+product.getPrice());
//        }

        ////Создание
        //транзакция во время использование JPA
//        Category category=new Category();
//        category.setName("Наушники");
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(category);//создание
//            entityManager.getTransaction().commit();
//            System.out.println(category.getId());
//        }catch (Exception e){
//            entityManager.getTransaction().rollback();
//            System.out.println(e.getMessage());
//        }

        //acid=
        //a- atomicity
////        ОБНОВЛЕНИЕ
//        Category category=entityManager.find(Category.class,3);
//        category.setName("Наушники и гарнитура UPDATED");
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.merge(category);//создание
//            entityManager.getTransaction().commit();
//            System.out.println(category.getId());
//        }catch (Exception e){
//            entityManager.getTransaction().rollback();
//            System.out.println(e.getMessage());
//        }

        /// УДАЛЕНИЕ
//        Category category=entityManager.find(Category.class,3);
//        category.setName("Наушники и гарнитура UPDATED");
//
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.remove(category);//создание
//            entityManager.getTransaction().commit();
//            System.out.println(category.getId());
//        }catch (Exception e){
//            entityManager.getTransaction().rollback();
//            System.out.println(e.getMessage());
//        }

//        Product product=entityManager.find(Product.class,1);
//        System.out.println(product.getName()+"."+product.getCategory().getName());
//
        ///task1
//        TypedQuery<Category> categories = entityManager.createQuery("select c from Category c ", Category.class);
//        int count = 0;
//        for (Category category : categories.getResultList()) {
//            for (Product product : category.getProducts()) {
//                System.out.println(product.getName() + ":");
//                for (Option option : category.getOptions()) {
//                    System.out.print(option.getName() + (":") );
//                    for (int i = count; i < product.getValues().size(); i++) {
//                        String name = product.getValues().get(i).getName();
//                        System.out.println(name);
//                        count++;
//                        if (count>=product.getValues().size()){
//                            count=0;
//                        }
//                        break;
//                    }
//                }
//
//            }
//
//        }
        /// task2
//        Category category = new Category();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("введите категорию:");
//        String categoryName = scanner.nextLine();
//        category.setName(categoryName);
//        System.out.println("введите название характеристик через запятую: ");
//        List<String> options=List.of(scanner.nextLine().split(","));
//        for (String names : options) {
//             Option option = new Option();
//            option.setName(names.trim());
//            option.setCategory(category);
//            category.getOptions().add(option);
//        }
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(category);//создание
//            for (int i = 0; i < category.getOptions().size(); i++) {
//                entityManager.persist(category.getOptions().get(i));
//            }
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            System.out.println(e.getMessage());
//        }
        /// Class task
//                TypedQuery<Category> categories = entityManager.createQuery("select c from Category c ", Category.class);
//        Product product=new Product();
//        System.out.println("выберите категорию:");
//        for (Category category:categories.getResultList()) {
//            System.out.println(category.getId()+"."+category.getName());
//        }
//        int idOfCategory=Integer.parseInt(scanner.nextLine());
//        Category category=categories.getResultList().get(idOfCategory-1);
//        System.out.println("name:");
//        String productName = scanner.nextLine();
//        System.out.println("Price:");
//        double productPrice= Double.parseDouble(scanner.nextLine());
//        product.setName(productName);
//        product.setPrice(productPrice);
//        product.setCategory(category);
//        for (Option option :category.getOptions()){
//            System.out.print(option.getName()+":");
//            String optionValue=scanner.nextLine();
//            Value value=new Value();
//            value.setOption(option);
//            value.setName(optionValue.trim());
//            value.setProduct(product);
//            product. getValues().add(value);
//        }
//
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(product);
//            entityManager.getTransaction().commit();
//        }catch (Exception e){
//            e.getMessage();
//        }
        System.out.print("Введите id товара: ");
        int idOfProduct = Integer.parseInt(scanner.nextLine());

        Product product = entityManager.find(Product.class, idOfProduct);

        System.out.println("\nВведите новое название товара [" + product.getName() + "]: ");
        String newName = scanner.nextLine();
        if (!newName.isBlank()) {
            product.setName(newName);
        }

        System.out.println("Введите новую стоимость товара [" + product.getPrice() + "]: ");
        String isNewPriceExists = scanner.nextLine();
        if (!isNewPriceExists.isBlank()) {
            product.setPrice(Double.parseDouble(isNewPriceExists));
        }
        for (Option option : product.getCategory().getOptions()) {
            Value value = product.getValues().stream()
                    .filter(v -> v.getOption().getId().equals(option.getId()))
                    .findFirst()
                    .orElse(null);

            String oldValue="null";
            if (value!=null){
                oldValue=value.getName();
            }

            System.out.print(option.getName() + " [" + oldValue + "]: ");
            String newValue = scanner.nextLine();

            if (!newValue.isBlank()) {
                if (value == null) {
                    value = new Value();
                    value.setProduct(product);
                    value.setOption(option);
                    product.getValues().add(value);
                }
                value.setName(newValue);
            }
        }
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            System.out.println("\n товар обновлён");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("ошибка: " + e.getMessage());
        }

    }
}


