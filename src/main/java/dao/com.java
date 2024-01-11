package dao;

import java.util.Date;


public class com {

	    private int commentId;
	    private int blogId;
	    private String content;
	    private String createdAt;
	    private int authorId;
	    
	    
	    
		public com(int commentId, int blogId, String content, String createdAt, int authorId) {
			super();
			this.commentId = commentId;
			this.blogId = blogId;
			this.content = content;
			this.createdAt = createdAt;
			this.authorId = authorId;
		}
	    
	    
	    
		public com( int blogId, String content, int authorId) {
			super();
			this.blogId = blogId;
			this.content = content;
			this.createdAt = createdAt;
			this.authorId = authorId;
		}
	    
		public com( ) {
			
			super();
		
		}
	    
	    
	    
	
		public int getCommentId() {
			return commentId;
		}
		public void setCommentId(int commentId) {
			this.commentId = commentId;
		}
		public int getBlogId() {
			return blogId;
		}
		public void setBlogId(int blogId) {
			this.blogId = blogId;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(String string) {
			this.createdAt = string;
		}
		public int getAuthorId() {
			return authorId;
		}
		public void setAuthorId(int authorId) {
			this.authorId = authorId;
		}
	
	
	
}
