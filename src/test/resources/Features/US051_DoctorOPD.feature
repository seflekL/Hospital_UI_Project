@smoke
Feature: Doktor dashboard sidebar messaging bölümüü testi

  @regression1

  Scenario:Doktor sisteme giriş yapar
    Given Doktor geçerli url ile giriş yapar
    And Gecerli User Name girer
    When Gecerli password girer
    When Sign In butonuna tıklar
    Then heal life logosu görüntülenir

  @regression

  Scenario:OPD linkine tıklanması ve list başlıklarının görüntülenmesi testi
    Given doktor sidebar da OPD linkine tiklanir
    When OPD Patient list başlıklari goruntulenmelidir
    Then Opd patient list sayfasida search box olmali
    Then searchbox a isim girilip arama yapilabilmeli

  @regression

  Scenario:OPD patient listin siralanmasi ve sayfada görüntülenecek kayit sayisinin secilmesi
    Given doktor sidebar da OPD linkine tiklanir
    When patient id e tiklanir ve bir numaralı hasta geldigi dogrulanir
    Then goruntulenecek hasta sayisi secilir

  @regression

  Scenario:show butonuna tiklanmasi ve overview sayfasinin görüntülenmesi testi
    Given doktor sidebar da OPD linkine tiklanir
    When show butonuna tiklanir
    Then overview sayfasi goruntulenir
    Then visits butonuna tiklanir
    Then visits sayfasi acilir
    And new visit butonuna tiklanir






