/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package withinoctane;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author bruijsez
 */
public class WithinOctane {

    public WithinOctane() throws ParseException, IOException, org.json.simple.parser.ParseException {
        Authentication authentication = new Authentication();
        GetChanged getchanged = new GetChanged(authentication);
        System.out.println("GetChanged " + getchanged.story()+"end of getchanged");
        PostStory poststory = new PostStory(authentication);
        System.out.println("PostStory " + poststory.PostStory());
       
    }

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException, IOException, org.json.simple.parser.ParseException {
        WithinOctane withinOctane = new WithinOctane();
    }

}
