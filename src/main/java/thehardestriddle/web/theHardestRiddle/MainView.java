package thehardestriddle.web.theHardestRiddle;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;


@Route("")
public class MainView extends VerticalLayout {
    private Language language = Language.GERMAN;
    private boolean clickActive = false;

    public MainView() {
        var button = new Button("Privacy Policy");
        var selctionLanguage = new Select<String>();
        selctionLanguage.setLabel("Language");
        selctionLanguage.setItems(Language.GERMAN.name(), Language.ENGLISH.name());
        selctionLanguage.setValue(Language.GERMAN.name());
        selctionLanguage.addValueChangeListener((HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<Select<String>, String>>) selectStringComponentValueChangeEvent -> {

            String result = selectStringComponentValueChangeEvent.getValue();
            if (result.equals(Language.ENGLISH.name())) {
                language = Language.ENGLISH;
            } else {
                language = Language.GERMAN;
            }

        });

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(selctionLanguage, button);
        add(verticalLayout);

        var privacyPolicy = new VerticalLayout();

        button.addClickListener((ComponentEventListener<ClickEvent<Button>>) buttonClickEvent -> {
            privacyPolicy.add(getPrivacyPolicy(language));
            if (clickActive) {
                remove(privacyPolicy);
                clickActive = false;
            } else {
                add(privacyPolicy);
                clickActive = true;
            }
        });
    }

    private VerticalLayout getPrivacyPolicy(Language language) {
        switch (language) {
            case GERMAN -> {
                return getGermanPrivacyPolicy();
            }
            case ENGLISH -> {
                return getEnglishPrivacyPolicy();
            }
            default -> throw new IllegalStateException("Unexpected value: " + language);
        }
    }

    private VerticalLayout getGermanPrivacyPolicy() {
        VerticalLayout result = new VerticalLayout();
        Paragraph all = new Paragraph();
        all.add("1. Einleitung\n" +
                "Die Nutzung dieser App kann mit der Verarbeitung von personenbezogenen Daten verbunden sein. Damit diese Verarbeitungen für Sie nachvollziehbar sind, möchten wir Ihnen mit den folgenden Informationen einen Überblick zu diesen Verarbeitungen verschaffen. Um eine faire Verarbeitung zu gewährleisten, möchten wir Sie außerdem über Ihre Rechte nach der Europäischen Datenschutzverordnung (DSV) und dem Datenschutzgesetz (DSG) informieren.\n" +
                "\n" +
                "1.2. Namen und Kontaktdaten des Verantwortlichen und Datenschutzbeaufgtragten\n" +
                "Wenn Sie Fragen oder Anregungen zu diesen Informationen haben oder sich wegen der Geltendmachung Ihrer Rechte an uns wenden möchten, richten Sie Ihre Anfrage bitte an\n" +
                "\n" +
                "Michael Wagner\n" +
                "Sömmerlistrasse 14\n" +
                "9000 St. Gallen\n" +
                "micwagne034@gmail.com\n" +
                "079 539 52 30\n" +
                "\n" +
                "Unser Datenschutzbeauftragter ist unter folgenden Kontaktdaten zu erreichen:\n" +
                "micwagne034@gmail.com\n" +
                "\n" +
                "2. Allgemeines zur Datenverarbeitung\n" +
                "Wir erheben und verwenden bei einem Besuch unserer App zunächst nur die in Abschnitt 3 genannten Daten. Darüber hinaus verarbeiten wir personenbezogene Daten unserer Nutzer grundsätzlich nicht. Die Erhebung und Verwendung personenbezogener Daten unserer Nutzer erfolgt einmalig und nur nach Einwilligung des Nutzers sich zu registrieren.\n" +
                "2.1 Rechtsgrundlage für die Verarbeitung personenbezogener Daten\n" +
                "Soweit wir für Verarbeitungsvorgänge personenbezogener Daten eine Einwilligung der betroffenen Person einholen, dient das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 lit. a EU-Datenschutzgrundverordnung (DSGVO) als Rechtsgrundlage für die Verarbeitung personenbezogener Daten.\n" +
                "Bei der Verarbeitung von personenbezogenen Daten, die zur Erfüllung eines Vertrages, dessen Vertragspartei die betroffene Person ist, erforderlich ist, dient das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 lit. b DSGVO als Rechtsgrundlage. Dies gilt auch für Verarbeitungsvorgänge, die zur Durchführung vorvertraglicher Massnahmen erforderlich sind.\n" +
                "Soweit eine Verarbeitung personenbezogener Daten zur Erfüllung einer rechtlichen Verpflichtung erforderlich ist, welcher unser Unternehmen unterliegt, dient das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 lit. c DSGVO als Rechtsgrundlage.\n" +
                "Ist die Verarbeitung zur Wahrung eines berechtigten Interesses unseres Unternehmens oder eines Dritten erforderlich und überwiegen die Interessen, Grundrechte und Grundfreiheiten des Betroffenen das erstgenannte Interesse nicht, so dient das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 lit. f DSGVO als Rechtsgrundlage für die Verarbeitung.\n" +
                "2.2 Datenlöschung und Speicherdauer\n" +
                "Die personenbezogenen Daten der betroffenen Person werden gelöscht oder gesperrt, sobald der Zweck der Speicherung entfällt. Eine Speicherung kann darüber hinaus dann erfolgen, wenn dies durch den europäischen oder nationalen Gesetzgeber in unionsrechtlichen Verordnungen, Gesetzen oder sonstigen Vorschriften, denen der Verantwortliche unterliegt, vorgesehen wurde. Eine Sperrung oder Löschung der Daten erfolgt auch dann, wenn eine durch die genannten Normen vorgeschriebene Speicherfrist abläuft, es sei denn, dass eine Erforderlichkeit zur weiteren Speicherung der Daten für einen Vertragsabschluss oder eine Vertragserfüllung besteht.\n" +
                "3. Bereitstellung der App \n" +
                "3.1 Beschreibung, Zweck und Umfang der Datenverarbeitung\n" +
                "Nur bei der Registrierung erfasst unsere App einmalig Daten für den Autentifizierungsprozess.\n" +
                "Folgende Daten werden hierbei erhoben:\n" +
                "•\tEmail, Nutzername und Passwort, dies geschieht über Firebase online und unterliegt deren AGB’s.\n" +
                "3.2 Rechtsgrundlage für die Datenverarbeitung\n" +
                "Rechtsgrundlage für die vorübergehende Speicherung der Daten und der Logfiles ist das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 lit. f DSGVO.\n" +
                " \n" +
                "3.3 Dauer der Speicherung\n" +
                "Die Daten werden gelöscht, sobald sie für die Erreichung des Zweckes ihrer Erhebung nicht mehr erforderlich sind. Technische Server-Logfiles werden nach 365 Tagen automatisch gelöscht.\n" +
                " \n" +
                "3.4 Widerspruchs- und Beseitigungsmöglichkeit\n" +
                "Die Erfassung der Daten zur Bereitstellung der Website und die Speicherung der Daten in Logfiles ist für den Betrieb der Webseite zwingend erforderlich. Es besteht folglich seitens des Nutzers keine Widerspruchsmöglichkeit. \n" +
                "5. Kontaktformulare und E-Mail-Kontakt\n" +
                "5.1 Beschreibung, Zweck und Umfang der Datenverarbeitung\n" +
                "Auf unserer App sind Kontaktinformationen jedoch keine Kontaktformulare vorhanden.\n" +
                " \n" +
                "5.2 Rechtsgrundlage für die Datenverarbeitung\n" +
                "Rechtsgrundlage für die Verarbeitung der Daten ist bei Vorliegen einer Einwilligung des Nutzers das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 lit. a DSGVO.\n" +
                "Rechtsgrundlage für die Verarbeitung der Daten, die im Zuge einer Übersendung einer E-Mail übermittelt werden, ist das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 lit. f DSGVO. Zielt der E-Mail-Kontakt auf den Abschluss eines Vertrages ab, so ist zusätzliche Rechtsgrundlage für die Verarbeitung das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 lit. b DSGVO.\n" +
                "                                                   \n" +
                "5.3 Dauer der Speicherung\n" +
                "Die Daten werden gelöscht, sobald sie für die Erreichung des Zweckes ihrer Erhebung nicht mehr erforderlich sind. Für die personenbezogenen Daten aus der Eingabemaske des Kontaktformulars und diejenigen, die per E-Mail übersandt wurden, ist dies dann der Fall, wenn die jeweilige Konversation mit dem Nutzer beendet ist. Beendet ist die Konversation dann, wenn sich aus den Umständen entnehmen lässt, dass der betroffene Sachverhalt abschliessend geklärt ist.\n" +
                "Die während des Absendevorgangs zusätzlich erhobenen personenbezogenen Daten werden spätestens nach einer Frist von sieben Tagen gelöscht.\n" +
                "5.4 Widerspruchs- und Beseitigungsmöglichkeit\n" +
                "Der Nutzer hat jederzeit die Möglichkeit, seine Einwilligung zur Verarbeitung der personenbezogenen Daten zu widerrufen. Nimmt der Nutzer per E-Mail (Kontaktformular) Kontakt mit uns auf, so kann er der Speicherung seiner personenbezogenen Daten jederzeit widersprechen. In einem solchen Fall kann die Konversation nicht fortgeführt werden und der Widerruf muss telefonisch erfolgen.\n" +
                "Alle personenbezogenen Daten, die im Zuge der Kontaktaufnahme gespeichert wurden, werden in diesem Fall gelöscht.\n" +
                "6. Registrierung auf dieser Website\n" +
                "Sie können sich auf unserer App registrieren um Zugang zum Spiel zu bekommen. Die dazu eingegebenen Daten verwenden wir nur zum Zwecke der Nutzung des jeweiligen Angebotes oder Dienstes, für den Sie sich registriert haben. Die bei der Registrierung abgefragten Pflichtangaben müssen vollständig angegeben werden. Anderenfalls werden wir die Registrierung ablehnen.\n" +
                "Für wichtige Änderungen etwa beim Angebotsumfang oder bei technisch notwendigen Änderungen nutzen wir die bei der Registrierung angegebene E-Mail-Adresse, um Sie auf diesem Wege zu informieren.\n" +
                "Die Verarbeitung der bei der Registrierung eingegebenen Daten erfolgt auf Grundlage Ihrer Einwilligung (Art. 6 Abs. 1 lit. a DSGVO). Sie können eine von Ihnen erteilte Einwilligung jederzeit widerrufen. Dazu reicht eine formlose Mitteilung per E-Mail an uns. Die Rechtmässigkeit der bereits erfolgten Datenverarbeitung bleibt vom Widerruf unberührt.\n" +
                "Die bei der Registrierung erfassten Daten werden von uns gespeichert, solange Sie auf unserer Website registriert sind und werden anschliessend gelöscht. Gesetzliche Aufbewahrungsfristen bleiben unberührt.\n" +
                " \n" +
                "7. Rechte der betroffenen Person\n" +
                "Werden personenbezogene Daten von Ihnen verarbeitet, sind Sie „betroffene Person“ im Sinne des Bundesgesetzes über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, der DSGVO und es stehen Ihnen folgende Rechte gegenüber uns als Verantwortlichem zu. Sie können von Ihren Rechten Gebrauch machen, indem Sie uns unter Angabe Ihres Anliegens kontaktieren.\n" +
                "7.1 Auskunftsrecht\n" +
                "Jede von der Verarbeitung personenbezogener Daten betroffene Person hat das Recht, jederzeit von dem für die Verarbeitung Verantwortlichen unentgeltliche Auskunft über die zu seiner Person gespeicherten personenbezogenen Daten sowie eine Kopie dieser Daten zu erhalten.\n" +
                "Sie können von dem Verantwortlichen eine Bestätigung darüber verlangen, ob personenbezogene Daten, die Sie betreffen, von uns verarbeitet werden.\n" +
                "7.2 Recht auf Berichtigung\n" +
                "Jede von der Verarbeitung personenbezogener Daten betroffene Person hat das Recht, die unverzügliche Berichtigung sie betreffender unrichtiger personenbezogener Daten zu verlangen. Ferner steht der betroffenen Person das Recht zu, unter Berücksichtigung der Zwecke der Verarbeitung, die Vervollständigung unvollständiger personenbezogener Daten -  auch mittels einer ergänzenden Erklärung - zu verlangen.\n" +
                "7.3 Recht auf Einschränkung der Verarbeitung\n" +
                "Jede von der Verarbeitung personenbezogener Daten betroffene Person hat das Recht, von dem Verantwortlichen die Einschränkung der Verarbeitung zu verlangen, wenn eine vom Gesetzgeber im Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, in Art. 18 Abs. 1 DSGVO vorgesehenen Voraussetzungen gegeben ist.\n" +
                "7.4 Recht auf Löschung\n" +
                "Jede von der Verarbeitung personenbezogener Daten betroffene Person hat das Recht, von dem Verantwortlichen zu verlangen, dass die sie betreffenden personenbezogenen Daten unverzüglich gelöscht werden, sofern einer der im Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, in Art. 17 Abs. 1 DSGVO genannten Gründe zutrifft.\n" +
                "7.5 Recht auf Datenübertragbarkeit\n" +
                "Jede von der Verarbeitung personenbezogener Daten betroffene Person hat das Recht, die sie betreffenden personenbezogenen Daten, welche durch die betroffene Person einem Verantwortlichen bereitgestellt wurden, in einem strukturierten, gängigen und maschinenlesbaren Format zu erhalten. Sie hat ausserdem das Recht, diese Daten einem anderen Verantwortlichen ohne Behinderung durch den Verantwortlichen, dem die personenbezogenen Daten bereitgestellt wurden, zu übermitteln, sofern die Verarbeitung auf der Einwilligung gemäss Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, Art. 6 Abs. 1 Buchstabe a DSGVO oder Art. 9 Abs. 2 Buchstabe a DSGVO oder auf einem Vertrag gemäss Art. 6 Abs. 1 Buchstabe b DSGVO beruht und die Verarbeitung mithilfe automatisierter Verfahren erfolgt.\n" +
                "7.6 Widerspruchsrecht\n" +
                "Jede von der Verarbeitung personenbezogener Daten betroffene Person hat das Recht, aus Gründen, die sich aus ihrer besonderen Situation ergeben, jederzeit gegen die Verarbeitung sie betreffender personenbezogener Daten, die aufgrund des Bundesgesetzes über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, von Art. 6 Abs. 1 Buchstaben e oder f DSGVO erfolgt, Widerspruch einzulegen. Dies gilt auch für ein auf diese Bestimmungen gestütztes Profiling.\n" +
                "Das Unternehmen verarbeitet die personenbezogenen Daten im Falle des Widerspruchs nicht mehr, es sei denn, wir können zwingende schutzwürdige Gründe für die Verarbeitung nachweisen, die den Interessen, Rechten und Freiheiten der betroffenen Person überwiegen, oder die Verarbeitung dient der Geltendmachung, Ausübung oder Verteidigung von Rechtsansprüchen.\n" +
                "Verarbeitet das Unternehmen personenbezogene Daten, um Direktwerbung zu betreiben, so hat die betroffene Person das Recht, jederzeit Widerspruch gegen die Verarbeitung der personenbezogenen Daten zum Zwecke derartiger Werbung einzulegen. Dies gilt auch für das Profiling, soweit es mit solcher Direktwerbung in Verbindung steht. Widerspricht die betroffene Person der Verarbeitung für Zwecke der Direktwerbung, so werden die personenbezogenen Daten nicht mehr für diese Zwecke verarbeiten.\n" +
                "7.7 Recht auf Widerruf der datenschutzrechtlichen Einwilligungserklärung\n" +
                "Jede von der Verarbeitung personenbezogener Daten betroffene Person hat das Recht, eine Einwilligung zur Verarbeitung personenbezogener Daten jederzeit zu widerrufen.\n" +
                "Sie haben das Recht, Ihre datenschutzrechtliche Einwilligungserklärung jederzeit zu widerrufen. Durch den Widerruf der Einwilligung wird die Rechtmässigkeit der aufgrund der Einwilligung bis zum Widerruf erfolgten Verarbeitung nicht berührt.\n" +
                "7.8 Recht auf Beschwerde bei einer Aufsichtsbehörde\n" +
                "Unbeschadet eines anderweitigen verwaltungsrechtlichen oder gerichtlichen Rechtsbehelfs steht Ihnen das Recht auf Beschwerde bei einer Aufsichtsbehörde, insbesondere in dem Mitgliedstaat ihres Aufenthaltsorts, ihres Arbeitsplatzes oder des Orts des mutmasslichen Verstosses, zu, wenn Sie der Ansicht sind, dass die Verarbeitung der Sie betreffenden personenbezogenen Daten gegen das Bundesgesetz über den Datenschutz (DSG) beziehungsweise, sofern und soweit anwendbar, die DSGVO verstösst.\n" +
                "8. Datenschutzbestimmungen zu Google Analytics\n" +
                "Der für die Verarbeitung Verantwortliche hat auf dieser Webseite die Komponente Google Analytics integriert. Google Analytics verwendet Cookies und speichert diese in der Regel ausserhalb des EU/EFTA Raumes. Google benutzt diese Informationen, um die Nutzung der Website auszuwerten und Reports über die Websiteaktivitäten und Internetnutzung zusammenzustellen. Des Weiteren überträgt Google diese Informationen nach eigenen Angaben an Dritte, sofern dies gesetzlich vorgeschrieben ist oder soweit Dritte diese Daten im Auftrag von Google verarbeiten. Die im Rahmen von Google Analytics vom Browser übermittelte IP-Adresse wird nicht mit anderen Daten von Google zusammengeführt. Die Nutzer können die Speicherung von Cookies verhindern (vgl. \"Cookies\" hiervor). Die Nutzer können darüber hinaus die Übermittlung der durch das Cookie erzeugten und auf ihre Nutzung der Website bezogenen Daten (inkl. IP-Adresse) an Google sowie die Verarbeitung dieser Daten durch Google verhindern, indem sie das unter dem folgenden Link verfügbare Browser-Plugin herunterladen und installieren: https://tools.google.com/dlpage/gaoptout?hl=de\n" +
                "9. Datenschutzbestimmungen zu Google reCaptcha\n" +
                "Wir nutzen “Google reCAPTCHA” (im Folgenden “reCAPTCHA”) auf unseren Websites. Anbieter ist die Google Inc., 1600 Amphitheatre Parkway, Mountain View, CA 94043, USA (“Google”).\n" +
                "Mit reCAPTCHA soll überprüft werden, ob die Dateneingabe auf unseren Websites (z.B. in einem Kontaktformular) durch einen Menschen oder durch ein automatisiertes Programm erfolgt. Hierzu analysiert reCAPTCHA das Verhalten des Websitebesuchers anhand verschiedener Merkmale. Diese Analyse beginnt automatisch, sobald der Websitebesucher die Website betritt. Zur Analyse wertet reCAPTCHA verschiedene Informationen aus (z.B. IP-Adresse, Verweildauer des Websitebesuchers auf der Website oder vom Nutzer getätigte Mausbewegungen). Die bei der Analyse erfassten Daten werden an Google weitergeleitet.\n" +
                "Die reCAPTCHA-Analysen laufen vollständig im Hintergrund. Websitebesucher werden nicht darauf hingewiesen, dass eine Analyse stattfindet.\n" +
                "Die Datenverarbeitung erfolgt auf Grundlage von Art. 6 Abs. 1 lit. f DSGVO. Der Websitebetreiber hat ein berechtigtes Interesse daran, seine Webangebote vor missbräuchlicher automatisierter Ausspähung und vor SPAM zu schützen.\n" +
                "Weitere Informationen zu Google reCAPTCHA sowie die Datenschutzerklärung von Google entnehmen Sie folgenden Links: https://www.google.com/intl/de/policies/privacy/ und https://www.google.com/recaptcha/intro/android.html.\n" +
                " \n" +
                " \n" +
                "10. Datenschutzbestimmungen zu YouTube\n" +
                "Auf unserer Website werden sogenannte Social Plugins („Plugins“) von YouTube integriert.              YouTube ist ein Internet-Videoportal, dass Video-Publishern das kostenlose Einstellen von Videoclips und anderen Nutzern die ebenfalls kostenfreie Betrachtung, Bewertung und Kommentierung dieser ermöglicht. YouTube gestattet die Publikation aller Arten von Videos, weshalb sowohl komplette Film- und Fernsehsendungen, aber auch Musikvideos, Trailer oder von Nutzern selbst angefertigte Videos über das Internetportal abrufbar sind.\n" +
                "Betreibergesellschaft von YouTube ist die YouTube, LLC, 901 Cherry Ave., San Bruno, CA 94066, USA. Die YouTube, LLC ist eine Tochtergesellschaft der Google Inc., 1600 Amphitheatre Pkwy, Mountain View, CA 94043-1351, USA.\n" +
                "Durch jeden Aufruf einer der Einzelseiten dieser Webseite, die durch den für die Verarbeitung Verantwortlichen betrieben wird und auf welcher eine YouTube-Komponente (YouTube-Video) integriert wurde, wird der Internetbrowser auf dem informationstechnologischen System der betroffenen Person automatisch durch die jeweilige YouTube-Komponente veranlasst, eine Darstellung der entsprechenden YouTube-Komponente von YouTube herunterzuladen. Weitere Informationen zu YouTube können unter https://www.youtube.com/yt/about/de/ abgerufen werden. Im Rahmen dieses technischen Verfahrens erhalten YouTube und Google Kenntnis darüber, welche konkrete Unterseite unserer Webseite durch die betroffene Person besucht wird.\n" +
                "Sofern die betroffene Person gleichzeitig bei YouTube eingeloggt ist, erkennt YouTube mit dem Aufruf einer Unterseite, die ein YouTube-Video enthält, welche konkrete Unterseite unserer Webseite die betroffene Person besucht. Diese Informationen werden durch YouTube und Google gesammelt und dem jeweiligen YouTube-Account der betroffenen Person zugeordnet.\n" +
                "YouTube und Google erhalten über die YouTube-Komponente immer dann eine Information darüber, dass die betroffene Person unsere Webseite besucht hat, wenn die betroffene Person zum Zeitpunkt des Aufrufs unserer Webseite gleichzeitig bei YouTube eingeloggt ist; dies findet unabhängig davon statt, ob die betroffene Person ein YouTube-Video anklickt oder nicht. Ist eine derartige Übermittlung dieser Informationen an YouTube und Google von der betroffenen Person nicht gewollt, kann diese die Übermittlung dadurch verhindern, dass sie sich vor einem Aufruf unserer Webseite aus ihrem YouTube-Account ausloggt.\n" +
                "Die von YouTube veröffentlichten Datenschutzbestimmungen, die unter https://www.google.de/intl/de/policies/privacy/ abrufbar sind, geben Aufschluss über die Erhebung, Verarbeitung und Nutzung personenbezogener Daten durch YouTube und Google.\n" +
                "11. Datenschutzbestimmungen zu Firebase\n" +
                "Auf unserer Website werden die oben erwähnten Daten auf Firebase gespeichert. Deswegen hier noch die geltenden Datenbestimmungen für Firebase. Hier der Link dazu Datenschutz und Sicherheit in Firebase (google.com).\n");
        result.add(all);
        return result;
    }


    private VerticalLayout getEnglishPrivacyPolicy() {
        VerticalLayout result = new VerticalLayout();
        Paragraph para = new Paragraph();
        String all = "1. introduction\n" +
                "The use of this app may involve the processing of personal data. In order to make these processing operations comprehensible to you, we would like to provide you with an overview of these processing operations with the following information. To ensure fair processing, we would also like to inform you about your rights under the European Data Protection Regulation (DPA) and the Data Protection Act (DPA).\n" +
                "\n" +
                "1.2 Name and contact details of the data controller and data protection officer\n" +
                "If you have any questions or suggestions regarding this information or would like to contact us about asserting your rights, please send your request to\n" +
                "\n" +
                "Michael Wagner\n" +
                "Sömmerlistrasse 14\n" +
                "9000 St. Gallen\n" +
                "micwagne034@gmail.com\n" +
                "079 539 52 30\n" +
                "\n" +
                "Our data protection officer can be reached at the following contact details:\n" +
                "micwagne034@gmail.com\n" +
                "\n" +
                "2. general information on data processing\n" +
                "When you visit our app, we initially only collect and use the data mentioned in section 3. Beyond that, we do not process personal data of our users as a matter of principle. The collection and use of our users' personal data takes place once and only after the user has consented to register.\n" +
                "2.1 Legal basis for the processing of personal data\n" +
                "Insofar as we obtain the consent of the data subject for processing operations involving personal data, the Federal Data Protection Act (DSG) or, if and insofar as applicable, Art. 6 (1) lit. a EU General Data Protection Regulation (DSGVO) serves as the legal basis for the processing of personal data.\n" +
                "In the case of processing of personal data that is necessary for the performance of a contract to which the data subject is a party, the Federal Data Protection Act (FADP) or, if and to the extent applicable, Article 6 (1) (b) FADP shall serve as the legal basis. This also applies to processing operations that are necessary for the implementation of pre-contractual measures.\n" +
                "If the processing of personal data is necessary to comply with a legal obligation to which our company is subject, the Federal Data Protection Act (FADP) or, if and insofar as applicable, Art. 6 para. 1 lit. c FADP serves as the legal basis.\n" +
                "If the processing is necessary to protect a legitimate interest of our company or a third party and the interests, fundamental rights and freedoms of the data subject do not outweigh the first-mentioned interest, the Federal Act on Data Protection (DSG) or, if and insofar as applicable, Article 6 (1) (f) DSGVO shall serve as the legal basis for the processing.\n" +
                "\n" +
                "2.2 Data deletion and storage period\n" +
                "The personal data of the data subject will be deleted or blocked as soon as the purpose of the storage no longer applies. In addition, storage may take place if this has been provided for by the European or national legislator in Union regulations, laws or other provisions to which the controller is subject. The data will also be blocked or deleted if a storage period prescribed by the aforementioned standards expires, unless there is a necessity for the continued storage of the data for the conclusion or fulfilment of a contract.\n" +
                "3 Provision of the app \n" +
                "3.1 Description, purpose and scope of data processing\n" +
                "Only during registration does our app collect data once for the authentication process.\n" +
                "The following data is collected in this process:\n" +
                "- Email, username and password, this is done via Firebase online and is subject to their T&Cs.\n" +
                "3.2 Legal basis for data processing\n" +
                "The legal basis for the temporary storage of the data and the log files is the Federal Data Protection Act (DSG) or, if and insofar as applicable, Art. 6 para. 1 lit. f DSGVO.\n" +
                " \n" +
                "3.3 Duration of storage\n" +
                "The data is deleted as soon as it is no longer required to achieve the purpose for which it was collected. Technical server log files are automatically deleted after 365 days.\n" +
                " \n" +
                "3.4 Possibility of objection and removal\n" +
                "The collection of data for the provision of the website and the storage of the data in log files is absolutely necessary for the operation of the website. Consequently, there is no possibility for the user to object.\n" +
                "\n" +
                "5. contact forms and e-mail contact\n" +
                "5.1 Description, purpose and scope of data processing\n" +
                "Contact information but no contact forms are available on our app.\n" +
                " \n" +
                "5.2 Legal basis for data processing\n" +
                "The legal basis for the processing of data is the Federal Data Protection Act (DSG) or, if and insofar as applicable, Art. 6 para. 1 lit. a DSGVO if the user has given his consent.\n" +
                "The legal basis for the processing of data transmitted in the course of sending an e-mail is the Federal Act on Data Protection (DSG) or, if and insofar as applicable, Art. 6 para. 1 lit. f DSGVO. If the e-mail contact is aimed at concluding a contract, the additional legal basis for the processing is the Federal Data Protection Act (FADP) or, if and to the extent applicable, Art. 6 para. 1 lit. b FADP.\n" +
                "                                                   \n" +
                "5.3 Duration of storage\n" +
                "The data is deleted as soon as it is no longer required to achieve the purpose for which it was collected. For the personal data from the input mask of the contact form and those sent by e-mail, this is the case when the respective conversation with the user has ended. The conversation is ended when the circumstances indicate that the matter in question has been conclusively clarified.\n" +
                "The additional personal data collected during the sending process will be deleted after a period of seven days at the latest.\n" +
                "5.4 Possibility of objection and removal\n" +
                "The user has the possibility to revoke his consent to the processing of personal data at any time. If the user contacts us by e-mail (contact form), he can object to the storage of his personal data at any time. In such a case, the conversation cannot be continued and the revocation must be made by telephone.\n" +
                "All personal data stored in the course of contacting us will be deleted in this case.\n" +
                "\n" +
                "6. registration on this website\n" +
                "You can register on our app to gain access to the game. We will only use the data entered for this purpose for the purpose of using the respective offer or service for which you have registered. The mandatory information requested during registration must be provided in full. Otherwise we will reject the registration.\n" +
                "For important changes, for example in the scope of the offer or in the case of technically necessary changes, we will use the e-mail address provided during registration to inform you in this way.\n" +
                "The processing of the data entered during registration is based on your consent (Art. 6 para. 1 lit. a DSGVO). You can revoke your consent at any time. For this purpose, an informal communication by e-mail to us is sufficient. The legitimacy of the data processing already carried out remains unaffected by the revocation.\n" +
                "The data collected during registration will be stored by us for as long as you are registered on our website and will then be deleted. Legal retention periods remain unaffected.\n" +
                " \n" +
                "7. rights of the data subject\n" +
                "If personal data of yours is processed, you are a \"data subject\" within the meaning of the Federal Data Protection Act (FADP) or, if and to the extent applicable, the GDPR, and you have the following rights vis-à-vis us as the controller. You can exercise your rights by contacting us stating your concern.\n" +
                "7.1 Right of access\n" +
                "Any person affected by the processing of personal data has the right to obtain from the controller, at any time and free of charge, information about the personal data stored about him or her and a copy of that data.\n" +
                "You may request confirmation from the controller as to whether personal data concerning you is being processed by us.\n" +
                "7.2 Right to rectification\n" +
                "Every person affected by the processing of personal data has the right to demand that inaccurate personal data concerning him or her be corrected without delay. The data subject shall also have the right to obtain, taking into account the purposes of the processing, the completion of any incomplete personal data, including by means of a supplementary declaration.\n" +
                "7.3 Right to restriction of processing\n" +
                "Any person affected by the processing of personal data has the right to request the controller to restrict the processing if one of the conditions provided for by the legislator in the Federal Data Protection Act (FADP) or, if and to the extent applicable, in Art. 18(1) FADP is met.\n" +
                "7.4 Right to erasure\n" +
                "Every person affected by the processing of personal data has the right to demand from the controller that the personal data concerning him or her be erased without undue delay if one of the grounds set out in the Federal Act on Data Protection (FADP) or, if and insofar as applicable, in Article 17(1) of the GDPR applies." +
                "7.5 Right to data portability\n" +
                "Every person affected by the processing of personal data has the right to receive the personal data concerning him or her, which has been provided by the data subject to a controller, in a structured, commonly used and machine-readable format. He or she also has the right to transmit this data to another controller without hindrance by the controller to whom the personal data was provided, provided that the processing is based on consent pursuant to the Federal Act on Data Protection (FADP) or, if and to the extent applicable, Art. 6(1)(a) FADP or Art. 9(2)(a) FADP or on a contract pursuant to Art. 6(1)(b) FADP and the processing is carried out with the aid of automated procedures.\n" +
                "7.6 Right of objection\n" +
                "Any person affected by the processing of personal data has the right to object at any time, on grounds relating to his or her particular situation, to the processing of personal data concerning him or her which is carried out on the basis of the Federal Act on Data Protection (FADP) or, if and to the extent applicable, of Art. 6(1)(e) or (f) of the FADP. This also applies to profiling based on these provisions.\n" +
                "The company shall no longer process the personal data in the event of the objection, unless we can demonstrate compelling legitimate grounds for the processing which override the interests, rights and freedoms of the data subject, or for the assertion, exercise or defence of legal claims.\n" +
                "If the company processes personal data for direct marketing purposes, the data subject shall have the right to object at any time to processing of personal data processed for such marketing. This also applies to profiling insofar as it is related to such direct marketing. If the data subject objects to the processing for direct marketing purposes, the personal data will no longer be processed for these purposes.\n" +
                "7.7 Right to revoke the declaration of consent under data protection law\n" +
                "Any person affected by the processing of personal data has the right to withdraw consent to the processing of personal data at any time.\n" +
                "You have the right to revoke your declaration of consent under data protection law at any time. The revocation of consent does not affect the lawfulness of the processing carried out on the basis of the consent until the revocation.\n" +
                "7.8 Right to complain to a supervisory authority\n" +
                "Without prejudice to any other administrative or judicial remedy, you have the right to lodge a complaint with a supervisory authority, in particular in the Member State of your place of residence, place of work or place of the alleged infringement, if you consider that the processing of personal data relating to you infringes the Federal Data Protection Act (DPA) or, if and to the extent applicable, the GDPR." +
                "8. privacy policy regarding Google Analytics\n" +
                "The controller has integrated the Google Analytics component on this website. Google Analytics uses cookies and usually stores them outside the EU/EFTA area. Google uses this information to evaluate the use of the website and compile reports on website activity and internet usage. Furthermore, Google transfers this information to third parties according to its own information, insofar as this is required by law or insofar as third parties process this data on behalf of Google. The IP address transmitted by the browser as part of Google Analytics is not merged with other data from Google. Users can prevent the storage of cookies (see \"Cookies\" above). Users can also prevent the transmission of the data generated by the cookie and related to their use of the website (including IP address) to Google and the processing of this data by Google by downloading and installing the browser plugin available at the following link: https://tools.google.com/dlpage/gaoptout?hl=de.\n" +
                "9. privacy policy regarding Google reCaptcha\n" +
                "We use \"Google reCAPTCHA\" (hereinafter \"reCAPTCHA\") on our websites. The provider is Google Inc, 1600 Amphitheatre Parkway, Mountain View, CA 94043, USA (\"Google\").\n" +
                "The purpose of reCAPTCHA is to verify whether data entry on our websites (e.g. in a contact form) is made by a human or by an automated program. For this purpose, reCAPTCHA analyzes the behavior of the website visitor based on various characteristics. This analysis starts automatically as soon as the website visitor enters the website. For the analysis, reCAPTCHA evaluates various information (e.g. IP address, time spent by the website visitor on the website or mouse movements made by the user). The data collected during the analysis is forwarded to Google.\n" +
                "The reCAPTCHA analyses run entirely in the background. Website visitors are not made aware that an analysis is taking place.\n" +
                "The data processing is based on Art. 6 para. 1 lit. f DSGVO. The website operator has a legitimate interest in protecting its web offers from abusive automated spying and from SPAM.\n" +
                "For more information on Google reCAPTCHA and Google's privacy policy, please see the following links: https://www.google.com/intl/de/policies/privacy/ and https://www.google.com/recaptcha/intro/android.html.\n" +
                "\n" +
                "10. privacy policy regarding YouTube\n" +
                "So-called social plugins (\"plugins\") from YouTube are integrated on our website.              YouTube is an Internet video portal that allows video publishers to post video clips free of charge and other users to view, rate and comment on them, also free of charge. YouTube allows the publication of all types of videos, which is why complete film and TV shows, but also music videos, trailers or videos made by users themselves can be accessed via the Internet portal.\n" +
                "The operating company of YouTube is YouTube, LLC, 901 Cherry Ave, San Bruno, CA 94066, USA. YouTube, LLC is a subsidiary of Google Inc, 1600 Amphitheatre Pkwy, Mountain View, CA 94043-1351, USA.\n" +
                "By each call of one of the individual pages of this website, which is operated by the controller and on which a YouTube component (YouTube video) has been integrated, the Internet browser on the information technology system of the data subject is automatically caused by the respective YouTube component to download a representation of the corresponding YouTube component from YouTube. Further information on YouTube can be found at https://www.youtube.com/yt/about/de/. Within the scope of this technical procedure, YouTube and Google receive knowledge of which specific sub-page of our website is visited by the data subject.\n" +
                "If the data subject is logged into YouTube at the same time, YouTube recognizes which specific sub-page of our website the data subject is visiting by calling up a sub-page that contains a YouTube video. This information is collected by YouTube and Google and assigned to the respective YouTube account of the data subject.\n" +
                "YouTube and Google always receive information via the YouTube component that the data subject has visited our website if the data subject is simultaneously logged into YouTube at the time of calling up our website; this takes place regardless of whether the data subject clicks on a YouTube video or not. If the data subject does not want this information to be transmitted to YouTube and Google, he or she can prevent the transmission by logging out of his or her YouTube account before accessing our website.\n" +
                "The privacy policy published by YouTube, which is available at https://www.google.de/intl/de/policies/privacy/, provides information about the collection, processing and use of personal data by YouTube and Google.\n" +
                "11. privacy policy regarding Firebase\n" +
                "On our website, the above-mentioned data is stored on Firebase. Therefore, here still the applicable data provisions for Firebase. Here is the link to Privacy and Security in Firebase (google.com).\n" +
                "\n";
        para.add(all);
        return result;
    }

}

