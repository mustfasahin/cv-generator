# CV Maker

Modern ve profesyonel CV'leri PDF formatında oluşturan Java tabanlı bir uygulama.

## 📋 İçindekiler

- [Genel Bakış](#genel-bakış)
- [Özellikler](#özellikler)
- [Teknolojiler](#teknolojiler)
- [Gereksinimler](#gereksinimler)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Proje Yapısı](#proje-yapısı)
- [Örnek Çıktı](#örnek-çıktı)
- [Özelleştirme](#özelleştirme)
- [Test](#test)
- [Lisans](#lisans)

## 🎯 Genel Bakış

CV Maker, iText7 kütüphanesini kullanarak profesyonel görünümlü CV'leri programatik olarak oluşturmanıza olanak tanıyan bir Java uygulamasıdır. Kişisel bilgiler, eğitim geçmişi, iş deneyimi, beceriler ve sertifikalar gibi tüm temel CV bileşenlerini destekler.

## ✨ Özellikler

- **Kişisel Bilgiler**: Ad, adres, telefon, e-posta ve profil fotoğrafı
- **Kişisel Profil**: Özgeçmiş ve kariyer özeti
- **Eğitim Geçmişi**: Okul, bölüm ve akademik başarılar
- **Beceriler**: Teknik ve profesyonel yetkinlikler
- **İş Deneyimi**: Şirket, pozisyon ve sorumluluklar
- **Sertifikalar**: Profesyonel sertifikalar ve eğitimler
- **Profil Fotoğrafı**: CV'ye resim ekleme desteği
- **Özelleştirilebilir Tasarım**: Yazı tipi, boyut ve düzen ayarları

## 🛠 Teknolojiler

- **Java 21**: Modern Java özellikleri
- **Maven**: Proje yönetimi ve bağımlılık yönetimi
- **iText7 (v8.0.5)**: PDF oluşturma ve düzenleme
  - Kernel modülü: PDF belge işlemleri
  - Layout modülü: Sayfa düzeni ve içerik yerleştirme
- **JUnit 5**: Birim testleri için

## 📋 Gereksinimler

- Java Development Kit (JDK) 21 veya üzeri
- Maven 3.6 veya üzeri
- IDE (IntelliJ IDEA, Eclipse, VS Code önerilir)

## 🚀 Kurulum

### 1. Projeyi Klonlayın veya İndirin

```bash
git clone <repository-url>
cd cvmaker
```

### 2. Maven Bağımlılıklarını İndirin

```bash
mvn clean install
```

### 3. Proje Yapılandırması

`App.java` dosyasında aşağıdaki yolları kendi sisteminize göre güncelleyin:

```java
// PDF çıktı yolu
String path = "to\\your\\path\\cv.pdf";

// Profil fotoğrafı yolu
String imagePath = "to\\your\\path\\example.jpg";
```

## 💻 Kullanım

### Basit Kullanım

```java
public static void main(String[] args) throws Exception {
    // 1. Kişisel bilgileri tanımlayın
    List<Person> personList = new ArrayList<>();
    personList.add(new Person(
        "Adınız Soyadınız",
        "Adresiniz",
        "+90 555 123 4567",
        "email@example.com"
    ));

    // 2. Hakkınızda bilgi ekleyin
    String aboutYourself = "Yazılım geliştirme alanında 5 yıllık deneyime sahip...";

    // 3. Eğitim bilgilerinizi ekleyin
    List<Education> educationList = new ArrayList<>();
    educationList.add(new Education(
        "09.2015 - 06.2019",
        "Üniversite Adı - Bölüm",
        "GPA: 3.5/4.0. Kulüp başkanlığı, yarışma kazananı."
    ));

    // 4. Becerilerinizi ekleyin
    String skills = "• Java, Python, JavaScript\n• Spring Boot, React\n• SQL, MongoDB";

    // 5. İş deneyimlerinizi ekleyin
    List<WorkExperience> workList = new ArrayList<>();
    workList.add(new WorkExperience(
        "01.2020 - Present",
        "Şirket Adı, Şehir",
        "Software Engineer",
        "Mikroservis mimarileri geliştirdim..."
    ));

    // 6. Sertifikalarınızı ekleyin
    String certificates = "• AWS Solutions Architect\n• Oracle Java Certified";

    // 7. PDF'i oluşturun
    createBasicPdf("output/cv.pdf", personList, aboutYourself,
        educationList, skills, workList, certificates);
}
```

### Uygulamayı Çalıştırma

**IDE ile:**

- `App.java` dosyasını açın
- `main` metoduna sağ tıklayın
- "Run" seçeneğini tıklayın

**Maven ile:**

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.mustafa.CVMaker.App"
```

## 📁 Proje Yapısı

```
cvmaker/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/mustafa/CVMaker/
│   │           ├── App.java              # Ana uygulama sınıfı
│   │           ├── Person.java           # Kişisel bilgiler model
│   │           ├── Education.java        # Eğitim bilgileri model
│   │           ├── WorkExperience.java   # İş deneyimi model
│   │           └── ...
│   └── test/
│       └── java/
│           └── com/mustafa/CVMaker/
├── pom.xml                               # Maven yapılandırması
└── README.md                             # Proje dokümantasyonu
```

### Sınıf Açıklamaları

#### `App.java`

Ana uygulama sınıfı. PDF oluşturma mantığını ve CV bileşenlerini düzenler.

**Temel Metodlar:**

- `createBasicPdf()`: PDF belgesini oluşturur
- `addPersonalDetails()`: Kişisel bilgileri ekler
- `addPersonalInfo()`: Kişisel profil metnini ekler
- `addEducation()`: Eğitim geçmişini ekler
- `addSkills()`: Beceri listesini ekler
- `addWorkExperience()`: İş deneyimlerini ekler
- `addCertificates()`: Sertifikaları ekler
- `addImage()`: Profil fotoğrafını ekler

#### `Person.java`

Kişisel bilgileri temsil eden model sınıfı.

#### `Education.java`

Eğitim bilgilerini temsil eden model sınıfı.

#### `WorkExperience.java`

İş deneyimi bilgilerini temsil eden model sınıfı.

## 📄 Örnek Çıktı

Uygulama aşağıdaki bileşenleri içeren profesyonel bir PDF CV oluşturur:

```
┌─────────────────────────────────────────┐
│ PERSONAL DETAILS                        │
│ Name: Shane Lawson          [PHOTO]     │
│ Address: P.O. Box 1605...               │
│ Phone: +1 (555) 123-4567                │
│ Email: shanelawson@gmail.com            │
├─────────────────────────────────────────┤
│ PERSONAL PROFILE                        │
│ Software engineer with 5 years...       │
├─────────────────────────────────────────┤
│ EDUCATION                               │
│ 09.2015 - 06.2019                       │
│ Stanford University - B.S. in CS        │
├─────────────────────────────────────────┤
│ SKILLS                                  │
│ • Programming: Java, Python...          │
├─────────────────────────────────────────┤
│ WORK EXPERIENCE                         │
│ Senior Software Engineer | TechVision   │
├─────────────────────────────────────────┤
│ CERTIFICATES                            │
│ • AWS Certified Solutions Architect     │
└─────────────────────────────────────────┘
```

## 🎨 Özelleştirme

### Yazı Tipi Değiştirme

```java
PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
// Mevcut fontlar: COURIER, HELVETICA, TIMES_ROMAN, vb.
```

### Sayfa Düzenini Değiştirme

```java
Table table = new Table(UnitValue.createPercentArray(new float[]{25, 75}));
// Kolon genişliklerini yüzde olarak ayarlayın
```

### Renk Ekleme

```java
import com.itextpdf.kernel.colors.ColorConstants;

paragraph.setFontColor(ColorConstants.BLUE);
```

### Profil Fotoğrafı Boyutu

```java
image.setWidth(100);  // Genişlik (piksel)
image.setHeight(100); // Yükseklik (piksel)
```

## 🧪 Test

JUnit 5 ile testleri çalıştırın:

```bash
mvn test
```

Test sınıfları oluşturmak için `src/test/java/com/mustafa/CVMaker/` dizininde test dosyaları ekleyin.

## 🔧 Sorun Giderme

### Common Issues

**Problem:** `java.io.FileNotFoundException`

```
Çözüm: Dosya yollarının doğru olduğundan ve yazma izninizin olduğundan emin olun.
```

**Problem:** Font hatası

```
Çözüm: StandardFonts enum değerlerini kullanın (COURIER, HELVETICA, vb.)
```

**Problem:** Resim görünmüyor

```
Çözüm: Resim yolunun doğru olduğunu ve dosyanın mevcut olduğunu kontrol edin.
```

## 📝 Gelecek Geliştirmeler

- [ ] Farklı CV şablonları
- [ ] Türkçe karakter desteği (Unicode font)
- [ ] CLI (Command Line Interface) desteği
- [ ] JSON/YAML dosyasından veri okuma
- [ ] Web tabanlı arayüz
- [ ] PDF önizleme özelliği
- [ ] Çoklu dil desteği

## 🤝 Katkıda Bulunma

1. Projeyi fork edin
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

## 👤 Yazar

**Mustafa**

- GitHub: [@mustfasahin](https://github.com/mustfasahin)
- Email: mstfasahn94@gmail.com

## 🙏 Teşekkürler

- [iText7](https://itextpdf.com/) - PDF oluşturma kütüphanesi
- [Maven](https://maven.apache.org/) - Proje yönetimi

---

⭐ Bu projeyi beğendiyseniz yıldız vermeyi unutmayın!
