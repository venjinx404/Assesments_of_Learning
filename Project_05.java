
import java.util.*;

enum AnswerOption {
        A, B, C, D
}

abstract class Question {
        protected String questionText;
        protected AnswerOption correctAnswer;
        protected int points;

        public Question(String questionText,
                        AnswerOption correctAnswer,
                        int points) {
                this.questionText = questionText;
                this.correctAnswer = correctAnswer;
                this.points = points;
        }

        public abstract boolean evaluate(AnswerOption answer)
                        throws Exception;

        public abstract void displayQuestion();

        public int getPoints() {
                return points;
        }

        public AnswerOption getCorrectAnswer() {
                return correctAnswer;
        }

        @Override
        public String toString() {
                return questionText;
        }
}

class MCQQuestion extends Question {
        private String optionA;
        private String optionB;
        private String optionC;
        private String optionD;

        public MCQQuestion(String questionText,
                        AnswerOption correctAnswer,
                        String optionA,
                        String optionB,
                        String optionC,
                        String optionD,
                        int points) {
                super(questionText, correctAnswer, points);

                this.optionA = optionA;
                this.optionB = optionB;
                this.optionC = optionC;
                this.optionD = optionD;
        }

        @Override
        public void displayQuestion() {
                System.out.println(questionText);
                System.out.println("A. " + optionA);
                System.out.println("B. " + optionB);
                System.out.println("C. " + optionC);
                System.out.println("D. " + optionD);
        }

        @Override
        public boolean evaluate(AnswerOption answer) {
                return answer == correctAnswer;
        }
}

class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(String questionText,
                        AnswerOption correctAnswer,
                        int points) {
                super(questionText, correctAnswer, points);
        }

        @Override
        public void displayQuestion() {
                System.out.println(questionText);
                System.out.println("A. True");
                System.out.println("B. False");
        }

        @Override
        public boolean evaluate(AnswerOption answer)
                        throws Exception {
                if (answer == AnswerOption.C ||
                                answer == AnswerOption.D) {
                        throw new Exception(
                                        "Invalid option. True/False questions only accept A or B.");
                }

                return answer == correctAnswer;
        }
}

public class Project_05 {
        public static AnswerOption parseInput(String input) {
                switch (input.toUpperCase()) {
                        case "A":
                                return AnswerOption.A;

                        case "B":
                                return AnswerOption.B;

                        case "C":
                                return AnswerOption.C;

                        case "D":
                                return AnswerOption.D;

                        default:
                                return null;
                }
        }

        public static String getRank(int score) {
                if (score >= 90)
                        return "Excellent!";

                if (score >= 70)
                        return "Great job!";

                if (score >= 50)
                        return "Not bad!";

                if (score >= 30)
                        return "Keep practicing!";

                return "Better luck next time!";
        }

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter your name: ");
                String playerName = sc.nextLine();

                int score = 0;
                int correct = 0;
                int incorrect = 0;

                ArrayList<Question> questionBank = new ArrayList<>();

                // MCQ Questions

                questionBank.add(new MCQQuestion(
                                "Which keyword is used to inherit a class?",
                                AnswerOption.B,
                                "implements",
                                "extends",
                                "inherits",
                                "super",
                                10));

                questionBank.add(new MCQQuestion(
                                "Which company developed Java?",
                                AnswerOption.C,
                                "Google",
                                "Microsoft",
                                "Sun Microsystems",
                                "Apple",
                                10));

                questionBank.add(new MCQQuestion(
                                "Which data type stores decimal values?",
                                AnswerOption.B,
                                "int",
                                "double",
                                "char",
                                "boolean",
                                10));

                questionBank.add(new MCQQuestion(
                                "Which collection follows LIFO?",
                                AnswerOption.D,
                                "Queue",
                                "ArrayList",
                                "LinkedList",
                                "Stack",
                                10));

                questionBank.add(new MCQQuestion(
                                "Which loop executes at least once?",
                                AnswerOption.C,
                                "for",
                                "while",
                                "do-while",
                                "foreach",
                                10));

                questionBank.add(new MCQQuestion(
                                "Which symbol ends a Java statement?",
                                AnswerOption.A,
                                ";",
                                ":",
                                ",",
                                ".",
                                10));

                questionBank.add(new MCQQuestion(
                                "Which access modifier is most restrictive?",
                                AnswerOption.D,
                                "public",
                                "protected",
                                "default",
                                "private",
                                10));

                questionBank.add(new MCQQuestion(
                                "Which operator compares values?",
                                AnswerOption.B,
                                "=",
                                "==",
                                "!=",
                                "+=",
                                10));

                questionBank.add(new MCQQuestion(
                                "Which class is used for user input?",
                                AnswerOption.A,
                                "Scanner",
                                "System",
                                "Math",
                                "String",
                                10));

                questionBank.add(new MCQQuestion(
                                "Java source files use which extension?",
                                AnswerOption.C,
                                ".class",
                                ".exe",
                                ".java",
                                ".jar",
                                10));

                // True / False Questions

                questionBank.add(new TrueFalseQuestion(
                                "Java is platform independent.",
                                AnswerOption.A,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "int can store decimal values.",
                                AnswerOption.B,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "Array index starts from 0.",
                                AnswerOption.A,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "Java supports multiple inheritance using classes.",
                                AnswerOption.B,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "String is a class in Java.",
                                AnswerOption.A,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "A constructor has a return type.",
                                AnswerOption.B,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "Stack follows FIFO.",
                                AnswerOption.B,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "Queue follows FIFO.",
                                AnswerOption.A,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "Java code is compiled into bytecode.",
                                AnswerOption.A,
                                10));

                questionBank.add(new TrueFalseQuestion(
                                "boolean can store true or false.",
                                AnswerOption.A,
                                10));

                Collections.shuffle(questionBank);

                ArrayList<Question> selected = new ArrayList<>(
                                questionBank.subList(0, 10));

                for (int i = 0; i < selected.size(); i++) {
                        Question q = selected.get(i);

                        System.out.println();
                        System.out.println("════════════════════════════════════════");
                        System.out.println(
                                        "Question "
                                                        + (i + 1)
                                                        + " of 10 | Score: "
                                                        + score
                                                        + " pts");
                        System.out.println("════════════════════════════════════════");

                        q.displayQuestion();

                        while (true) {
                                System.out.print("\nYour answer: ");

                                String input = sc.nextLine();

                                AnswerOption ans = parseInput(input);

                                if (ans == null) {
                                        System.out.println(
                                                        "Invalid input. Please enter A, B, C or D.");
                                        continue;
                                }

                                try {
                                        boolean result = q.evaluate(ans);

                                        if (result) {
                                                System.out.println(
                                                                "Correct! +10 pts");

                                                score += q.getPoints();
                                                correct++;
                                        } else {
                                                System.out.println(
                                                                "Wrong!");

                                                System.out.println(
                                                                "Correct Answer: "
                                                                                + q.getCorrectAnswer());

                                                incorrect++;
                                        }

                                        break;
                                } catch (Exception e) {
                                        System.out.println(
                                                        "NOOO!!" + e.getMessage());
                                }
                        }
                }

                System.out.println();
                System.out.println("╔══════════════════════════════════════╗");
                System.out.println("║          QUIZ COMPLETE!             ║");
                System.out.println("╠══════════════════════════════════════╣");
                System.out.println("║ Player  : " + playerName);
                System.out.println("║ Score   : " + score + " / 100");
                System.out.println("║ Correct : " + correct);
                System.out.println("║ Wrong   : " + incorrect);
                System.out.println("║ Rank    : " + getRank(score));
                System.out.println("╚══════════════════════════════════════╝");

                sc.close();
        }
}
