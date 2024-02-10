package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();


        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule separés par # */
        /* TO DO 1  hint(reduce)*/;
        // reduce => The reduction process combines all elements of the stream into a single result by applying the accumulation function .
        String names = teachers.stream().map(Teacher::getName).reduce((s1,s2)->s1.toUpperCase()+"#"+s2.toUpperCase()).orElse("");
//        String names = teachers.stream().map(Teacher::getName).map(t->t.toUpperCase()).reduce((s1,s2)->s1+"#"+s2).orElse("");
        System.out.println(names);
//        String names = teachers.stream().map(Teacher::getName).reduce((s1,s2)->s1.toUpperCase()+"#"+s2.toUpperCase()).get();
//        String names = teachers.stream().map(Teacher::getName).map(String::toUpperCase).collect(Collectors.joining("#"));

        /* TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream().filter(t->t.getSalary()>80000).collect(Collectors.toSet());/* TO DO 3 */;

        /* TO DO 3: Retourner une TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        // There isn't a toTreeSet method; instead, we use toCollection and it requires a Supplier.
        TreeSet<Teacher> teachers2 = teachers.stream().collect(Collectors.toCollection(
                                             ()->new TreeSet<>(Comparator.comparing(Teacher::getName).thenComparing(Teacher::getSalary))
                )
        );

        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        /* groupingBy => to transform a stream of elements into a map where the keys are derived from the properties of the stream elements,
         and the values are lists of the elements that share the same key*/
        Map<Subject, List<Teacher>> map = teachers.stream().collect(Collectors.groupingBy(Teacher::getSubject));

        /* TO DO 5: Retourner une Map qui regroupe les nom des enseignants par salaire */
        Map<Integer, String> map1 = teachers.stream().collect(Collectors.toMap(
                                                               // Key Mapper
                                                                Teacher::getSalary,
                                                                // Value Mapper
                                                                Teacher::getName,
                                                                //MergeFunction For avoid DuplicatedKey
                                                                (a,b)->a+","+b
                                                                                )
                );

        /* TO DO 6: Afficher les nom des enseignants de chaque module */


    }
}
