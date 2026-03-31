# Detaylı Arama - Karar Tablosu (Decision Table)

Bu tablo, sistemdeki `Detaylı Arama` formunun "Kelime", "Kategori" ve "Fiyat" filtrelerinin kombinasyonlarını nasıl işlediğini test etmek için %100 kapsama (coverage) hedefiyle oluşturulmuştur.

**Önemli Sistem Davranışı:** Arama kutusu boş bırakılsa dahi sistem diğer filtreleri (Kategori, Fiyat) yok saymaz, bu filtrelere uygun ürünleri listelemeye devam eder.

| Koşullar (Conditions) | R1 | R2 | R3 | R4 | R5 | R6 | R7 | R8 |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **C1:** Kelime Girildi mi? ("çanta") | Hayır | Hayır | Hayır | Hayır | Evet | Evet | Evet | Evet |
| **C2:** Kategori Seçildi mi? (Giyim) | Hayır | Hayır | Evet | Evet | Hayır | Hayır | Evet | Evet |
| **C3:** Fiyat Girildi mi? (100-500)  | Hayır | Evet | Hayır | Evet | Hayır | Evet | Hayır | Evet |
| | | | | | | | | |
| **Beklenen Sonuçlar (Actions)** | | | | | | | | |
| **A1:** Herhangi bir filtre olmadan tümünü getir / Varsayılan listeleme yap | **X** | | | | | | | |
| **A2:** Sadece *Fiyat* filtresi uygula | | **X** | | | | | | |
| **A3:** Sadece *Kategori* filtresi uygula | | | **X** | | | | | |
| **A4:** *Kategori + Fiyat* filtresi uygula | | | | **X** | | | | |
| **A5:** Sadece *Kelimeye* göre ara | | | | | **X** | | | |
| **A6:** *Kelime + Fiyat* filtresi uygula | | | | | | **X** | | |
| **A7:** *Kelime + Kategori* filtresi uygula | | | | | | | **X** | |
| **A8:** Tüm filtreleri (*Kelime + Kategori + Fiyat*) uygula | | | | | | | | **X** |