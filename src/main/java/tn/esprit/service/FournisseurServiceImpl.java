package tn.esprit.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.entities.Fournisseur;

import tn.esprit.repository.FournisseurRepository;

@Service
public class FournisseurServiceImpl implements FournisseurService{
	

	@Autowired
	FournisseurRepository fournisseurrepository;
	
	@Override
	public List<Fournisseur> retrieveAllFournisseur() {
        List <Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurrepository.findAll();
		return fournisseurs;
	}
	


	@Override
	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		return fournisseurrepository.save(fournisseur);
	}

	
	@Override
	public void deleteFournisseur(Long id) {
		fournisseurrepository.deleteById(id);
		
	}

	
	@Override
	public Fournisseur updateFournisseur(Fournisseur fournisseur) {
		if (fournisseurrepository.existsById(fournisseur.getIdfournisseur())){
			Fournisseur f = fournisseurrepository.findById(fournisseur.getIdfournisseur()).get();
			f.setCodefournisseur(fournisseur.getCodefournisseur());
			f.setLibellefournisseur(fournisseur.getLibellefournisseur());
			f.setNumerofournisseur(fournisseur.getNumerofournisseur());
			fournisseurrepository.save(f);
		}
		
		return fournisseur;
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		Fournisseur f =fournisseurrepository.findById(id).get();
		return f;
	}



	@Override
	public void fournisseurpdf(long idfournisseur) {
		try {
			Fournisseur f = fournisseurrepository.findById(idfournisseur).get();
			System.out.println("aa"+f);
	
			List<Fournisseur> cities = (List<Fournisseur>) fournisseurrepository.findAll();

			System.out.println("ttttttttttttt" + cities);
			String file_name=null;
			file_name="D:\\workspace_spring\\Desktop\\fournisseur\\FOURNISSEUR_" + idfournisseur + ".pdf";
			Document document = new Document(PageSize.A4, 15, 15, 45, 30);

			PdfWriter.getInstance(document, new FileOutputStream(file_name));

			document.open();
		
			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------------"));
			//////////////////////////// pdfDetailFournisseur
			Font font = FontFactory.getFont("Cooper Black", 15, BaseColor.BLUE);
			
			Font mainFont = FontFactory.getFont("Cooper Black", 35, BaseColor.BLACK);
			Paragraph para = new Paragraph("Detail Fournisseur N° " + f.getIdfournisseur(), mainFont);
			para.setAlignment(Element.ALIGN_CENTER);
			para.setIndentationLeft(10);
			para.setIndentationRight(10);
			para.setSpacingAfter(10);
			document.add(para);
			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			///////////////////
		
			PdfPTable table2 = new PdfPTable(4);
			Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
			Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
			PdfPCell name = new PdfPCell(new Paragraph("Quantite", tableHeader));
			name.setBorderColor(BaseColor.BLACK);
			name.setPaddingLeft(10);
			name.setHorizontalAlignment(Element.ALIGN_CENTER);
			name.setVerticalAlignment(Element.ALIGN_CENTER);
			name.setBackgroundColor(BaseColor.LIGHT_GRAY);
			name.setExtraParagraphSpace(5f);
			

			

			

			
			/////////////////////////////
			/////////////////////////////
			/////////////////////////////
			////////////////////////////
			for (Fournisseur c : cities) {
			;

				
			}

			/////////////////////////////////
			PdfPCell Idfournisseur = new PdfPCell(new Paragraph("identifiant Fournisseur", tableHeader));
			Idfournisseur.setBorderColor(BaseColor.BLACK);
			Idfournisseur.setPaddingLeft(10);
			Idfournisseur.setHorizontalAlignment(Element.ALIGN_CENTER);
			Idfournisseur.setVerticalAlignment(Element.ALIGN_CENTER);
			Idfournisseur.setBackgroundColor(BaseColor.LIGHT_GRAY);
			Idfournisseur.setExtraParagraphSpace(5f);
			table2.addCell(Idfournisseur);

			PdfPCell Codefournisseur = new PdfPCell(new Paragraph("Code Fournisseur", tableHeader));
			Codefournisseur.setBorderColor(BaseColor.BLACK);
			Codefournisseur.setPaddingLeft(10);
			Codefournisseur.setHorizontalAlignment(Element.ALIGN_CENTER);
			Codefournisseur.setVerticalAlignment(Element.ALIGN_CENTER);
			Codefournisseur.setBackgroundColor(BaseColor.LIGHT_GRAY);
			Codefournisseur.setExtraParagraphSpace(5f);
			table2.addCell(Codefournisseur);
			
			PdfPCell numerofournisseur = new PdfPCell(new Paragraph("Numéro Fournisseur", tableHeader));
			numerofournisseur.setBorderColor(BaseColor.BLACK);
			numerofournisseur.setPaddingLeft(10);
			numerofournisseur.setHorizontalAlignment(Element.ALIGN_CENTER);
			numerofournisseur.setVerticalAlignment(Element.ALIGN_CENTER);
			numerofournisseur.setBackgroundColor(BaseColor.LIGHT_GRAY);
			numerofournisseur.setExtraParagraphSpace(5f);
			table2.addCell(numerofournisseur);

			PdfPCell Libellefournisseur = new PdfPCell(new Paragraph("Libelle Fournisseur", tableHeader));
			Libellefournisseur.setBorderColor(BaseColor.BLACK);
			Libellefournisseur.setPaddingLeft(10);
			Libellefournisseur.setHorizontalAlignment(Element.ALIGN_CENTER);
			Libellefournisseur.setVerticalAlignment(Element.ALIGN_CENTER);
			Libellefournisseur.setBackgroundColor(BaseColor.LIGHT_GRAY);
			Libellefournisseur.setExtraParagraphSpace(5f);
			table2.addCell(Libellefournisseur);

			PdfPCell Idfournisseur1 = new PdfPCell(
					new Paragraph(String.valueOf(f.getIdfournisseur()), tableHeader));
			Idfournisseur1.setBorderColor(BaseColor.BLACK);
			Idfournisseur1.setPaddingLeft(10);
			Idfournisseur1.setHorizontalAlignment(Element.ALIGN_CENTER);
			Idfournisseur1.setVerticalAlignment(Element.ALIGN_CENTER);
			Idfournisseur1.setBackgroundColor(BaseColor.WHITE);
			Idfournisseur1.setExtraParagraphSpace(5f);
			table2.addCell(Idfournisseur1);
 
			PdfPCell Codefournisseur1 = new PdfPCell(
					new Paragraph(String.valueOf(f.getCodefournisseur()), tableHeader));
			Codefournisseur1.setBorderColor(BaseColor.BLACK);
			Codefournisseur1.setPaddingLeft(10);
			Codefournisseur1.setHorizontalAlignment(Element.ALIGN_CENTER);
			Codefournisseur1.setVerticalAlignment(Element.ALIGN_CENTER);
			Codefournisseur1.setBackgroundColor(BaseColor.WHITE);
			Codefournisseur1.setExtraParagraphSpace(5f);
			table2.addCell(Codefournisseur1);

			
			
			PdfPCell numerofournisseur1 = new PdfPCell(
					new Paragraph(String.valueOf(f.getNumerofournisseur()), tableHeader));
			numerofournisseur1.setBorderColor(BaseColor.BLACK);
			numerofournisseur1.setPaddingLeft(10);
			numerofournisseur1.setHorizontalAlignment(Element.ALIGN_CENTER);
			numerofournisseur1.setVerticalAlignment(Element.ALIGN_CENTER);
			numerofournisseur1.setBackgroundColor(BaseColor.WHITE);
			numerofournisseur1.setExtraParagraphSpace(5f);
			table2.addCell(numerofournisseur1);
			
			
			PdfPCell Libellefournisseur1 = new PdfPCell(
					new Paragraph(String.valueOf(f.getLibellefournisseur()), tableHeader));
			Libellefournisseur1.setBorderColor(BaseColor.BLACK);
			Libellefournisseur1.setPaddingLeft(10);
			Libellefournisseur1.setHorizontalAlignment(Element.ALIGN_CENTER);
			Libellefournisseur1.setVerticalAlignment(Element.ALIGN_CENTER);
			Libellefournisseur1.setBackgroundColor(BaseColor.WHITE);
			Libellefournisseur1.setExtraParagraphSpace(5f);
			table2.addCell(Libellefournisseur1);

		

			document.add(new Paragraph("  "));

			document.add(table2);
			document.add(new Paragraph("  "));
			document.add(new Paragraph("  "));

			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph("  "));
			document.add(new Paragraph("  "));

			document.add(new Paragraph("Téléphone  :(+216) 72 000 000   "
					+ "                                                             Adresse : Ariana "));
			document.add(new Paragraph("Fax          :(+216) 72 000 000   "
					+ "                                                                                      Code Postal :4000  "));
			document.add(new Paragraph("Email       :EspritTn@esprit.tn  "));

			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
