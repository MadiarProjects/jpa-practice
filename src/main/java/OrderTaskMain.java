import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.*;

import java.util.*;

public class OrderTaskMain {
    public static void main(String[] args) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("default");
        EntityManager em=factory.createEntityManager();
        Scanner scanner=new Scanner(System.in);
        Order order=new Order();
        User user=new User();
        System.out.println("enter login:");
        String login=scanner.nextLine();
        user.setLogin(login);
        System.out.println("enter the password:");
        String password=scanner.nextLine();
        user.setPassword(password);
        System.out.println("enter the address:");
        String address=scanner.nextLine();
        order.setUser(user);
        order.setDeliveryAddress(address);
        List<Product> products=em.createQuery("select p from Product p",Product.class).getResultList();
        for (Product product:products){
            System.out.println(product.getId()+"."+product.getName()+"("+product.getPrice()+")");
        }
        System.out.println("choose the products:");
        String productsIds=scanner.nextLine();

        List<Long> ids = Arrays.stream(productsIds.split(","))
                .map(String::trim)
                .map(Long::parseLong)
                .toList();


        double total = 0;
        List<OrderProducts>orderProducts=new ArrayList<>();
        for (Long id : ids) {
            Product product = products.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElseThrow();

            System.out.println(
                    "Введите кол-во для товара \"" + product.getName() + "\""
            );
            int count = Integer.parseInt(scanner.nextLine());
            OrderProducts orderProduct=new OrderProducts();
            orderProduct.setProduct(product);
            orderProduct.setCount(count);
            orderProduct.setOrder(order);
            orderProducts.add(orderProduct);
            total += product.getPrice() * count;
        }
        order.setOrderProducts(orderProducts);
        order.setStatus(OrderStatus.CREATED);
        System.out.println("order created.");
        System.out.println("user:"+order.getUser().getLogin());
        System.out.println("status:"+order.getStatus());
        System.out.println("products:");
        for (OrderProducts ordProd:order.getOrderProducts()){
            System.out.println("-"+ordProd.getProduct().getName()+" x"+ordProd.getCount()+"("+ordProd.getProduct().getPrice()*ordProd.getCount()+")");
        }
        System.out.println("total:"+total);
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.persist(order);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }
}
