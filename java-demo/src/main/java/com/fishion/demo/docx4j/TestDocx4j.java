package com.fishion.demo.docx4j;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Text;

import com.sunwayworld.framework.utils.Docx4jUtils;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月15日 16:41
 */
public class TestDocx4j {
    public static void main(String[] args) {
        Path path = Paths.get("F:\\sunway\\svn\\sunway-app-casic201\\src\\main\\java\\com\\sunwayworld\\casic\\module\\cm\\cs\\casicreceivecontract\\io\\templates\\casicReceiveContractSimpleFormExportTemplate.docx");

        WordprocessingMLPackage wordprocessingMLPackage;

        {
            try {
                wordprocessingMLPackage = WordprocessingMLPackage.load(path.toFile());
                MainDocumentPart mainDocumentPart = wordprocessingMLPackage.getMainDocumentPart();
                System.out.println(mainDocumentPart);
                List<Object> texts = Docx4jUtils.getAllElementFromObject(mainDocumentPart, Text.class);
                System.out.println(texts);
                org.docx4j.wml.ObjectFactory factory = Context.getWmlObjectFactory();
                Object o = texts.get(8);
                Text text = (Text) o;
                R r1 = (R) text.getParent();
                P p = (P) r1.getParent();
                Tc tc = (Tc) p.getParent();

                List<Object> cells = Docx4jUtils.getAllElementFromObject(mainDocumentPart, Tc.class);

                Tc cell = (Tc) cells.get(41);
                P p1 = factory.createP();
                R r = factory.createR();
                Text text1 = factory.createText();
                text1.setValue("helloworld");
                r.getContent().add(text1);
                p1.getContent().add(r);
                cell.getContent().add(2, p1);
                P helloworld = mainDocumentPart.createParagraphOfText("helloworld2");
                System.out.println(cell);
                cell.getContent().add(3, helloworld);
                // wordprocessingMLPackage.save(path.toFile());

            } catch (Docx4JException e) {
                e.printStackTrace();
            }
        }

    }


}
