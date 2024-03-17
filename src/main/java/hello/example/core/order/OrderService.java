package hello.example.core.order;

public interface OrderService {
    //1.주문생성-회원 id, 상품명, 상품가격을 넘겨줌
    Order createOrder(Long memberId,String itemName, int itemPrice);

}
