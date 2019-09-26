package tests;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import java.util.Arrays;

import com.mongodb.DB;

public class Mongodbclass {

	public static void main(String[] args) {
		
		MongoCredential credential = MongoCredential.createCredential("test","epsilon_test","EpTe123".toCharArray());
		@SuppressWarnings("deprecation")
		MongoClient mongoClient = new MongoClient(new ServerAddress("139.59.177.90", 27017), Arrays.asList(credential));
		MongoDatabase db = mongoClient.getDatabase( "test" );
		MongoCollection collection = db.getCollection("posts");
		FindIterable fi = collection.find();
		MongoCursor cursor = fi.iterator();
		
	//	MongoClient mongoClient = new  MongoClient("139.59.177.90",27017);
	//MongoClientURI uri = new MongoClientURI("mongodb://test:EpTe123@139.59.177.90:27017/?authSource=test");
	//	MongoClient mongoClientlogin = new MongoClient(uri);
	//	mongoClient.getCredential();
		
		System.out.println("connection is done");
		
		
		
	//	DB db = mongoClient.getDB("epsilon_test");
			
		
	//	DBCollection coll = db.getCollection("posts");
		
	//	DBCursor cursor = coll.find();
		while (cursor.hasNext())
		{
			int i=1;
			System.out.println("cursor is " + cursor.next());
			i++;
			
			
		}
		

	}

}
