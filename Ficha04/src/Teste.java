import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        int q;
        Scanner in = new Scanner (System.in);
        System.out.println("Question Number: ");
        q = in.nextInt();
        switch(q){
            case 1:
                StackStr s = new StackStr();
                System.out.println(s.toString());
                s.push("Hello");
                s.push("Beautiful");
                s.push("World");
                System.out.println(s.toString());
                System.out.println(s.length());
                System.out.println(s.top());
                StackStr s2 = s.clone();
                System.out.println(s.equals(s2));
                s2.pop();
                System.out.println(s.equals(s2));
                System.out.println(s.empty());
                System.out.println(s2.toString());
                System.out.println(s2.top());
                break;
            case 2:
                LocalDate date = LocalDate.now();
                LinhaEncomenda l = new LinhaEncomenda("ABCJJJ", "Bom produto", 200.20, 10, 0.23, 0.10);
                LinhaEncomenda l1 = new LinhaEncomenda("AD", "Mau produto", 20.20, 100, 0.24, 0.12);
                LinhaEncomenda l2 = new LinhaEncomenda("CE", "Grande", 10.20, 1, 0.24, 0.12);
                List<LinhaEncomenda> ar = new ArrayList<LinhaEncomenda>();
                ar.add(l1);
                ar.add(l2);
                ar.add(l);
                EncEficiente e1 = new EncEficiente("Francisco Neves", 1111111, "Casa Branca", "ABC765BD", date, ar);
                System.out.println(e1.toString());
                e1.removeProduto("AD");
                System.out.println(e1.toString());
                e1.adicionaLinha(l1);
                System.out.println(e1.toString());
                System.out.println("Valor total: " + e1.calculaValorTotal());
                System.out.println("Valor de desconto: " + e1.calculaValorDesconto());
                EncEficiente e2 = e1.clone();
                System.out.println(e2.equals(e1));
                e2.removeProduto("AD");
                System.out.println(e2.toString());
                System.out.println(e1.toString());
                System.out.println(e2.equals(e1));
                System.out.println(e2.existeProdutoEncomenda("CE"));
                System.out.println(e2.numeroTotalProdutos());
                break;
            case 3:
                Lamp lam = new Lamp();
                Lamp lam2 = lam.clone(), lam3 = lam.clone();
                List<Lamp> lampList = new ArrayList<Lamp>();
                lampList.add(lam);
                lampList.add(lam2);
                SmartHome sh = new SmartHome(lampList);
                System.out.println(sh.toString());
                sh.addLamp(lam3);
                sh.allEco();
                System.out.println(sh.toString());
                sh.tOnLampNormal(2);
                sh.removeLamp(1);
                System.out.println(sh.toString());
                sh.allMax();
                System.out.println(sh.toString());
                sh.allEco();
                System.out.println(sh.howMuchEco());
                System.out.println(sh.totalConsume());
                sh.reset();
                System.out.println(sh.toString());
                break;
            case 4:
                LocalDateTime dt = LocalDateTime.of(1999, Month.MARCH, 25, 14, 9);
                LocalDateTime d2 = LocalDateTime.of(1999, Month.MARCH, 26, 3, 2);
                FBPost p1 = new FBPost(1, "Zuckerberg", dt, "Hello, dear Diary.", 50);
                FBPost p4 = new FBPost(4, "Zuckerberg", d2, "Life brings you when lemons make lemonade", 100);
                ArrayList<String> coms1 = new ArrayList();
                coms1.add("Dumb");
                coms1.add("Hello, darling. Check my profile ;)");
                coms1.add("YES!");
                FBPost p2 = new FBPost(2, "Steve Jobs", dt, "Samsung kek", 70, coms1);
                FBPost p3 = new FBPost(3, "Must", dt, "It's me, Mario", 0);
                FBPost p5 = new FBPost(5, "Mario", dt, "Sorry, Virus", 0);

                ArrayList<FBPost> feed = new ArrayList<>();
                feed.add(p1);
                feed.add(p2);
                feed.add(p3);
                feed.add(p4);
                feed.add(p5);

                FBFeed f = new FBFeed(feed);

                f.comment(2, "Loser");
                f.comment(f.getPost(1), "Hello, Mark");
                f.comment(3, "Must or Musk?");
                f.like(p2);
                f.like(p4);

                System.out.println(f.nrPosts("Zuckerberg"));
                System.out.println(f.toString());
                System.out.println(f.getPost(4).toString());
                System.out.println(f.postsOf("Zuckerberg", dt, LocalDateTime.now()).toString());
                System.out.println(f.top5CommentsE().toString());
                System.out.println(f.top5CommentsI().toString());
                break;
            default:
                break;
        }
    }
}
