package com.lgcns.example.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class GroupingByTest {

	public static void main(String[] args) {
		
		// PRINT STEP
		int idx = 2;
		
		// 1. create List
		List<BlogPost> posts;
		posts = createBlogPosts();

		// 2. Simple Grouping by a Single Column
		Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().collect(groupingBy(BlogPost::getType));
		System.out.printf("## %d ## - %s\n", (idx++), postsPerType);

		// 3. Grouping by With a Complex Map Key Type
		Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
				.collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
		System.out.printf("## %d ## - %s\n", (idx++), postsPerTypeAndAuthor);

		// 4. Modifying the Returned Map Value Type
		Map<BlogPostType, Set<BlogPost>> postsPerType2 = posts.stream().collect(groupingBy(BlogPost::getType, toSet()));
		System.out.printf("## %d ## - %s\n", (idx++), postsPerType2);

		// 5. Grouping by Multiple Fields
		Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream()
				.collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));
		System.out.printf("## %d ## - %s\n", (idx++), map);

		// 6. Getting the Average from Grouped Results
		Map<BlogPostType, Double> averageLikesPerType = posts.stream()
				.collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));
		System.out.printf("## %d ## - %s\n", (idx++), averageLikesPerType);

		// 7. Getting the Sum from Grouped Results
		Map<BlogPostType, Integer> likesPerType = posts.stream()
				.collect(Collectors.groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));
		System.out.printf("## %d ## - %s\n", (idx++), likesPerType);

		// 8. Getting the Maximum or Minimum from Grouped Results
		Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
				.collect(groupingBy(BlogPost::getType, maxBy(comparingInt(BlogPost::getLikes))));
		System.out.printf("## %d ## - %s\n", (idx++), maxLikesPerPostType);

		// 9. Getting a Summary for an Attribute of Grouped Results
		Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = posts.stream()
				.collect(groupingBy(BlogPost::getType, summarizingInt(BlogPost::getLikes)));
		System.out.printf("## %d ## - %s\n", (idx++), likeStatisticsPerType);

		// 10. Mapping Grouped Results to a Different Type
		Map<BlogPostType, String> postsPerType3 = posts.stream()
				  .collect(groupingBy(BlogPost::getType, 
				  mapping(BlogPost::getTitle, joining(", ", "Post titles: [", "]"))));
		System.out.printf("## %d ## - %s\n", (idx++), postsPerType3);

	}

	private static List<BlogPost> createBlogPosts() {
		return Arrays.asList(new BlogPost("1.Stream", "scmrts", BlogPostType.GUIDE, 80),
				new BlogPost("2.Functional", "neolaozi", BlogPostType.REVIEW, 20),
				new BlogPost("3.Collection", "lasher", BlogPostType.GUIDE, 70),
				new BlogPost("4.Sorting", "korea1", BlogPostType.GUIDE, 40),
				new BlogPost("5.NIO", "sunoj", BlogPostType.REVIEW, 50),
				new BlogPost("6.Generic", "parkty", BlogPostType.REVIEW, 30),
				new BlogPost("7.Java8", "hanjh", BlogPostType.NEWS, 10));
	}
}

enum BlogPostType {
	NEWS, REVIEW, GUIDE
}

class Tuple {
	BlogPostType type;
	String author;

	public Tuple(BlogPostType type, String author) {
		super();
		this.type = type;
		this.author = author;
	}
}

class BlogPost {
	String title;
	String author;
	BlogPostType type;
	int likes;

	public BlogPost(String title, String author, BlogPostType type, int likes) {
		super();
		this.title = title;
		this.author = author;
		this.type = type;
		this.likes = likes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BlogPostType getType() {
		return type;
	}

	public void setType(BlogPostType type) {
		this.type = type;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}
