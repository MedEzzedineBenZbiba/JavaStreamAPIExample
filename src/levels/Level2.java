package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        /*TO DO 1 */
//        count => to determine the total number of elements in a collection
        long nbr = teachers.stream().filter(teacher -> teacher.getName().startsWith("s")).count();

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        // .sum() => to calculate the total of numeric values in a collection
        // .matToLong => t to transform the elements of a stream into a stream of long values
        long sum = teachers.stream().filter(t->t.getSubject().equals(Subject.FLUTTER)).mapToLong(t -> t.getSalary()).sum();/* TO DO 2 */;

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
                                                                                                        // Optimal Double  // Double
//        double average = teachers.stream().filter(t->t.getName().startsWith("a")).mapToDouble(t->t.getSalary()).average().getAsDouble()/* TO DO 3 */;
        double average = teachers.stream().filter(t->t.getName().startsWith("a")).mapToDouble(Teacher::getSalary).average().orElse(0.0)/* TO DO 3 */;;


        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
                                                                                            // java > 16 sinon .collect(Collectors.toList())
        List<Teacher> teachers1 = teachers.stream().filter(t->t.getName().startsWith("j")).toList();/* TO DO 4 */;


        /* TO DO 5: Retourner true si il y a au min un enseignants dont le salaire > 100000, false si non */
//        anyMatch => to determine if there is at least one element in the stream that meets a certain condition.
        boolean test = teachers.stream().anyMatch(t->t.getSalary()>100000) /* TO DO 6 */;

        /* TO DO 6: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes */
        /*First way*/
//        findFirst => to retrieve the first element from a sequence
        teachers.stream().filter(t->t.getName().startsWith("g")).filter(t->t.getSubject().equals(Subject.UNITY)).findFirst().ifPresent(System.out::println);           /* TO DO 7 */;

        /*Second way*/
//        Limit => returns a new stream consisting of the first n elements of the original stream.
        teachers.stream().filter(t->t.getName().startsWith("g")).filter(t->t.getSubject().equals(Subject.UNITY)).limit(1).forEach(System.out::println); /* TO DO 7 */;

        /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream()
                .filter((t->t.getName().startsWith("s"))) //limit(2) .skip(1) .foreach()
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);/* TO DO 8 */;

    }
}
