# 좋은 객체 지향 설계의 5가지 원칙 : SOLID (SRP, OCP, LSP , ISP , DIP)
## SRP(Single Responsibility Principle), 단일 책임 원칙
한 클래스는 하나의 책임만 가져야 한다.
변경이 있을 때 파급 효과가 적으면 잘 따른 것이다.

## OCP(Open/Closed Principle), 개방 폐쇄 원칙
소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
ex) 애플리케이션의 구성 영역으로 AppConfig를 추가하고, 클라이언트 코드를 사용 영역으로 두었다. 할인 정책을 변경하고 싶을 때, 구성 영역인 AppConfig가 구현체 `FixDiscountPolicy` -> `RateDiscountPolicy` 로 변경하여 클라이언트 코드에 주입하므로 클라이언트 코드를 변경하지 않고도 구체 클래스를 변경할 수 있었다. 이는 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀있다는 것이다.

## LSP(Liskov Substitution Principle), 리스코프 치환 원칙
프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 변경할 수 있어야 한다.

## ISP(Interface Segregation Principle), 인터페이스 분리 원칙
특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
적당히 잘 분리해서 인터페이스가 명확해지고, 대체 가능성이 높아지게 해야 한다.

## DIP(Dependency Inversion Principle), 의존 관계 역전 원칙
추상화에 의존해야지, 구체화에 의존하면 안된다. 의존성 주입은 이 원칙을 따르는 방법 중 하나다.
인터페이스(역할) 에 의존해야 한다.