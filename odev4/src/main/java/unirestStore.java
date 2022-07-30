import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class unirestStore {

    ////////
    //In UniRest, I realized whether the pet store Post operation I had done in Postman was successful.
    ////////

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    //Java Faker used
    //petId has 3 characters
    Faker faker1 = new Faker(new Random(3));
    String petId = faker1.petId().buildingNumber();

    String storeBody="(\"{\\r\\n  \\\"id\\\": 3,\\r\\n  \\\"petId\\\": 152,\\r\\n  \\\"quantity\\\": 0,\\r\\n  \\\"shipDate\\\": \\\"2022-07-30T15:45:54.972Z\\\",\\r\\n  \\\"status\\\": \\\"placed\\\",\\r\\n  \\\"complete\\\": true\\r\\n}\")\n";
    @Test
    public void makeStoreRequest{
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://petstore.swagger.io/v2/store/order")
                .header("Content-Type", "application/json")
                .body(storeBody)
               //.body("{\r\n  \"id\": 3,\r\n  \"petId\": 152,\r\n  \"quantity\": 0,\r\n  \"shipDate\": \"2022-07-30T15:45:54.972Z\",\r\n  \"status\": \"placed\",\r\n  \"complete\": true\r\n}")
                .asString();

        System.out.println(storeBody);
        Assert.assertEquals(expected: 200,response.getStatus());
        //Assert.assertEquals(response.getBody().getObject().get("message"),"Post operation successfully!");

    }



    @Test
    public void checkStoreRequest{

    }

    @Test
    public void checkStoreResponse{

    }


}



