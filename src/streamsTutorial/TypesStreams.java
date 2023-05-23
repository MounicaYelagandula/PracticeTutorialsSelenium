package streamsTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class TypesStreams {

		// TODO Auto-generated method stub
		
		//count the number of name sstarting with alphabet A in list
		@Test
		public void test1()
		{
			ArrayList<String> names=new ArrayList<>();
			names.add("Ahan");
			names.add("Radha");
			names.add("Jay");
			names.add("Arjun");
			
			Long c=names.stream().filter(s->s.startsWith("A")).count();
			System.out.println(c);
			
			Stream.of("Amaze","Honda","Toyota","Merc").filter(s->s.length()>4).forEach(s->System.out.println(s));
			
			//get only one result from stream
			Stream.of("Amaze","Honda","Toyota","Merc").filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
			
			//print names length>4 in uppercase
			Stream.of("Amaze","Honda","Toyota","Merc").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
			.forEach(s->System.out.println(s));
			
			//print names first letter as a with upaercase and sorted
			Stream.of("Amaze","Honda","Toyota","Merc").filter(s->s.startsWith("a")).sorted().
			map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
			ArrayList<String> names2=new ArrayList<>();
			names2.add("Ahan");
			names2.add("Harper");
			names2.add("Jay");
			names2.add("Arjun");
			//merge two lists
			Stream<String> newStream=Streams.concat(names.stream(),names2.stream());
			
			boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("ahan"));
			Assert.assertTrue(flag);
			
			//collecting streams
			//convert the final stream into a list
			List<String> ls=		Stream.of("Amaze","Honda","Toyota","Merc").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
			.collect(Collectors.toList());
			//get first element of ls
			System.out.println(ls.get(0));
			
			
			//print unique numbers in integer array
			List<Integer> numbers=Arrays.asList(57,56,34,556,86,55,33,34,6,8,13);
			numbers.stream().distinct().forEach(s->System.out.println(s));
			System.out.println("--------------------------");
			List<Integer> numlist=numbers.stream().filter(a->a.equals(5)).map(a->a+2).limit(4).collect(Collectors.toList());
			numlist.forEach(a->System.out.println(a));
			
			
			
		}
	

}
