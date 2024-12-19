@smoke
Feature: Doktor paneli Ana sayfası özellikleri

  @regression1
  Scenario:Login sayfasina dogru datalar ile sisteme girilmesi testi
    Given Doktor geçerli url ile giriş yapar
    Then Gecerli User Name girer
    Then Gecerli password girer
    And Sign In butonuna tıklar

  @regression1
  Scenario:Doktorlara gonderilen post mesajlarinin goruntulenmesi testi
    Given Doktor geçerli url ile giriş yapar
    Then Gecerli User Name girer
    Then Gecerli password girer
    Then Sign In butonuna tıklar
    Then heal life logosu görüntülenir
    And navbar altinda post mesajlari bölümü oldugu dogrulanir

  @regression
  Scenario:Doktora ait takvimin görüntülenmesi ve işlemler yapılabilmesi testi
    Given Doktor geçerli url ile giriş yapar
    Then Gecerli User Name girer
    Then Gecerli password girer
    Then Sign In butonuna tıklar
    And takvim bolumune gelinir
    Then Month tiklanir ve gun secilir
    Then Event title, event date, event color ve event type bolumleri doldurulur
    And save butonuna tiklanir

  @regression1
  Scenario:Sisteme kayitli calisan sayisinin goruntulenmesi testi
    Given Doktor geçerli url ile giriş yapar
    Then Gecerli User Name girer
    Then Gecerli password girer
    Then Sign In butonuna tıklar
    Then calisan sayisi bolumune gelinir
    Then accountant in 27 oldugu dogrulanir
    Then doctor un 30 oldugu dogrulanir
    Then pharmacist in 26 oldugu dogrulanir
    Then pathologist in 26 oldugu dogrulanir
    Then radiologist in 26 oldugu dogrulanir
    Then super admin in 1 oldugu dogrulanir
    Then receptionist in 26 oldugu dogrulanir
    And Nurse in 27 oldugu dogrulanir

  @regression
  Scenario: TC05 Çalışan sayisi boardlarina tiklanarak human resources sayfasina yönlendirmesi testi.
    Given Doktor geçerli url ile giriş yapar
    Then Gecerli User Name girer
    Then Gecerli password girer
    Then Sign In butonuna tıklar
    Then calisan sayisi bolumune gelinir
    Then kullanici doctor a tiklar
    And human resources sayfasina yönlendirdigi test edilir












