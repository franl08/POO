public class Test {
    public static void main(String[] args){
        Aluno a1 = new Aluno("a1", 20, "Jorge", "MIEI");
        Aluno a2 = new Aluno ("a2", 20, "Jorginho", "MIEI");
        TurmaAlunos t = new TurmaAlunos("Jorges", "SerJorge");
        t.insereAluno(a1);
        t.insereAluno(a2);
        System.out.println(t.getAluno("a2"));
    }
}
