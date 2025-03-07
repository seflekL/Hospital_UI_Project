@smoke
Feature: Doktor olarak doktor panelindeki menulerin toplandigi bir dashboard sidebar'inin olmasini istiyorum.
  @regression
  Scenario: Admin sitesi dogrulama
    Given Doktor "HLadminUrl" sitesine gider
    When Doktor email olarak "DoctorMailLevent" ve password olarakda "Passwords" ile giriş yapar

  @regression
  Scenario: TC06 Doktor olarak Dashboard SideBar'da menülerin olmasını istiyorum

    Then Doktor sayfasında Dashboard SideBar'da menüleri görünür ve aktif olmalı
    And Doktor browser kapatır
  @regression
  Scenario: TC07 Doktor olarak Dashboard SideBar'da menülerin doğru sayfaya ulaşmasını istiyorum

    Then Doktor sayfasında Dashboard SideBar'daki menüler dogru sayfaya ulmaşmalı
    And Doktor browser kapatır

  @regression
  Scenario: TC08 Doktor olarak Dashboard SideBar'ı kapalı olduğunca iconlarının görünür olmasını istiyorum

    Then Doktor sayfasında Hamburger menüye tıklayıp SideBar'ı kapatır
    And Doktor sayfasında Dashboard SideBar'ı kapalı oldugunda iconlar gorunur olmalı
    And Doktor browser kapatır