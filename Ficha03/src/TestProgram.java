import java.util.*;


public class TestProgram {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Insert question number: ");
        int q = in.nextInt();
        switch(q){
            case 1:
                Circle circle1 = new Circle();
                System.out.println("Correct values: predefined circle, x = y = 0 && radius = 1");
                System.out.println(circle1.toString());
                double radius = 3.4, x = 2.9, y = 4.1;
                Circle circle2 = new Circle(2.9, 4.1, 3.4);
                System.out.println("Correct values: circle2, x = 2.9, y = 4.1, radius = 3.4");
                System.out.println(circle2.toString());
                System.out.println("Area = " + circle2.area() + ", Perimeter = " + circle2.perimeter());
                Circle circle3 = new Circle(circle2);
                System.out.println("Correct values: copy of circle2, x = 2.9, y = 4.1, radius = 3.4");
                System.out.println(circle3.toString());
                circle3.changeCenter(2, 3);
                System.out.println("Correct values: moved circle3, x = 2, y = 3, radius = 3.4");
                System.out.println(circle3.toString());
                circle3.setX(3);
                circle3.setY(7);
                circle3.setRadius(4);
                System.out.println("Correct values: setters circle3, x = 3, y = 7, radius = 4");
                System.out.println(circle3.toString());
                break;
            case 2:
                ArrayList<String> apps = new ArrayList<String>();
                apps.add("F1TV");
                apps.add("FIFA");
                ArrayList <String> msg = new ArrayList<String>();
                msg.add("Hello");
                msg.add("World!");
                Phone phone1 = new Phone("Apple", "iPhone", 1920, 1080, 2000, 5000, 5000, 20, 2, 2, apps, msg);
                System.out.println(phone1.toString());
                Phone phone2 = new Phone(phone1);
                System.out.println(phone2.toString());
                System.out.println(phone1.equals(phone2) + " vs Expected: true");
                phone1.installApp("Instagram", 20);
                System.out.println(phone1.toString());
                System.out.println(phone1.equals(phone2) + " vs Expected: false");
                phone1.newMsg("IAMTHEBIGGESTONE&NOONECANDENYTHAT");
                System.out.println(phone1.toString());
                System.out.println(phone1.biggestMsg());
                phone1.removeApp("Instagram", 20);
                System.out.println(phone1.toString());
                phone1.averageAppSize();
                System.out.println("Average app size: " + phone1.averageAppSize());
                break;
            case 3:
                ArrayList<String> comms = new ArrayList<String>();
                Date up = new GregorianCalendar(2020, Calendar.DECEMBER, 25).getTime();
                comms.add("Scam");
                comms.add("Like before watch");
                Youtube video1 = new Youtube("Look what happened", 225454, up, 1080, 25, 12, comms, 25, 12);
                System.out.println(video1.toString());
                Youtube video2 = new Youtube(video1);
                System.out.println(video2.toString());
                System.out.println(video1.equals(video2) + " vs Expected: true");
                video2.thumbsUp();
                System.out.println(video2.toString());
                System.out.println(video1.equals(video2) + " vs Expected: false");
                video1.insertComment("Top video: 5 stars!");
                System.out.println(video1.toString());
                System.out.println("Days since upload: " + video1.daysLater());
                System.out.println("Code to process: " + video1.process());
                break;
            case 4:
                Lamp lamp1 = new Lamp();
                System.out.println(lamp1.toString());
                lamp1.lampOn();
                System.out.println(lamp1.toString());
                Lamp lamp2 = new Lamp(lamp1);
                System.out.println(lamp2);
                System.out.println(lamp1.equals(lamp2) + " vs Expected: true");
                lamp1.updateCons();
                System.out.println(lamp1.toString());
                lamp1.resetCons();
                System.out.println(lamp1.getTempConsume());
                lamp1.lampEco();
                lamp1.updateCons();
                System.out.println(lamp1.toString());
                lamp1.lampOff();
                System.out.println(lamp1.toString());
                break;
            case 5:
                Game game1 = new Game();
                System.out.println(game1.toString());
                game1.startGame();
                System.out.println(game1.toString());
                Game game2 = game1.clone(game1);
                System.out.println(game2);
                System.out.println(game2.equals(game1));
                game2.awayGoal();
                System.out.println(game2 + " " + game1);
                System.out.println(game2.equals(game1));
                game1.homeGoal();
                System.out.println(game2 + " " + game1);
                game1.endGame();
                System.out.println(game2 + " " + game1);
                game2.endGame();
                break;
            case 6:
                Car car1 = new Car("Opel", "Corsa", 2011, 4.3, 1);
                System.out.println(car1.toString());
                car1.turnOn();
                car1.moveCar(1000000, 200);
                System.out.println(car1.toString());
                Car car2 = new Car(car1);
                System.out.println(car2);
                System.out.println(car2.equals(car1));
                car2.breakCar(2000);
                System.out.println(car2);
                System.out.println(car2.equals(car1));
                car1.resetLastTrip();
                System.out.println(car1);
                car1.moveCar(1000, 3);
                System.out.println(car1);
                break;
            case 7:
                OrderLine ord1 = new OrderLine();
                System.out.println(ord1.toString());
                OrderLine ord2 = new OrderLine("xYweEwS", "great!", 200.15, 200000, 24, 10);
                System.out.println(ord2.toString());
                OrderLine ord3 = new OrderLine(ord2);
                System.out.println(ord3.equals(ord2));
                System.out.println(ord3.orderLineValue());
                System.out.println(ord2.discountValue());
                break;
            case 8:
                Order e1 = new Order();
                System.out.println(e1.toString());
                OrderLine ord4 = new OrderLine("xYweEwS", "great!", 200.15, 200000, 24, 10);
                OrderLine ord5 = new OrderLine("xYweEwZ", "great!", 20.15, 2000, 24, 5);
                Date dat = new Date();
                ArrayList<OrderLine> lines = new ArrayList<>(2);
                lines.add(ord4);
                lines.add(ord5);
                Order e2 = new Order("Me", 2333,"Home", 2222, dat, lines);
                System.out.println(e2.toString());
                System.out.println(e2.existsInOrder("xYweEwZ"));
                System.out.println("" + e2.totalProducts());
                System.out.println("" + e2.totalValue() + " | " + e2.totalDiscount());
                e2.removeProduct("xYweEwZ");
                System.out.println(e2.toString());
                System.out.println(e2.equals(e1));
                Order e3 = new Order(e2);
                System.out.println(e2.toString());
                System.out.println(e3.toString());
                System.out.println(e2.equals(e3));
                break;
            case 9:
                Points p1 = new Points(2,5);
                Points p2 = new Points(-1, 9);
                Points p3 = new Points(0, -9);
                Triangles t1 = new Triangles();
                System.out.println(t1.toString());
                Triangles t2 = new Triangles(p1, p2, p3);
                System.out.println(t2.toString());
                System.out.println(t1.equals(t2));
                Triangles t3 = new Triangles(t2);
                System.out.println(t2.equals(t3));
                System.out.println("" + t2.area());
                System.out.println("" + t2.perimeter());
                System.out.println("" + t2.height());
                break;
            default:
                break;
        }
    }
}
