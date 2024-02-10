package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */

//        ForEach =>  execute a certain operation on each item in a collection without returning a new collection or modifying the original one
                                    // Lambda expression
        teachers.stream().forEach(t-> System.out.println(t));

        // Another solution using method references
        teachers.stream().forEach(System.out::println);

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
//        filter => to include only those elements in the resulting stream that satisfy a given condition
        teachers.stream().filter(t->t.getName().startsWith("n")).forEach(t-> System.out.println(t));

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */

        teachers.stream().filter(s->s.getName().startsWith("n")).filter(s->s.getSalary()>10000).forEach(teacher->System.out.println(teacher));
        teachers.stream().filter(s->s.getName().startsWith("n")).filter(s->s.getSalary()>10000).forEach(System.out::println);

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances  )
         */
        //  Distinct => to eliminate duplicate elements from a sequence
        teachers.stream().filter(t->t.getSubject().equals(Subject.JAVA)).distinct().sorted((o1, o2) -> o1.getSalary() - o2.getSalary()).forEach(teacher -> System.out.println(teacher) );
        teachers.stream().filter(t->t.getSubject().equals(Subject.JAVA)).distinct().sorted((o1, o2) -> o1.getSalary() - o2.getSalary()).forEach(System.out::println);

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */
        teachers.stream().filter(teacher -> teacher.getSalary()>60000).forEach(teacher -> System.out.println(teacher.getName()));
        /* Second Way */
        // َMap =>  to convert the elements of a stream from one type to another or to extract some property from each element
        teachers.stream().filter(teacher -> teacher.getSalary()>6000).map(Teacher::getName).forEach(nom -> System.out.println(nom));

        teachers.stream().filter(teacher -> teacher.getSalary()>6000).map(teacher -> teacher.getName()).forEach(System.out::println);

        teachers.stream().filter(teacher -> teacher.getSalary()>6000).map(Teacher::getName).forEach(System.out::println);

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        teachers.stream()
                .filter(teacher->teacher.getName()
                        .startsWith("m"))
        // Peek => To perform an action on each element of the stream as they are consumed from the resulting stream. unlike forEach, peek can be used in the middle of a stream pipeline.
                .peek(teacher -> teacher.setSalary(teacher.getSalary()+200))
        // max(Comparator<T> comparator) => returns an Optional describing the maximum element of the stream according to the natural ordering of the elements or by a custom comparator provided to the method.
                .max((o1, o2) -> o1.getSalary()- o2.getSalary()).
        // ifPresent => method in Java's Optional class is used to execute a block of code if the Optional contains a non-null value
                ifPresent(m->System.out.println(m));

    }
}
