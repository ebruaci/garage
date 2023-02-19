# garage
</br>Projede 10 slotlu bir garaj sistemi kurgulanmıştır.
</br>Garaj için giriş yapabilecek 3 tür araç bulunmaktadır. CAR, JEEP ve TRUCK
</br>Giriş yapan her araç için 1 boş slot bırakılmaktadır.
</br>Garaja giriş yapan her araç için plaka ve renk bilgisi alan bir info sınıfı bulunmaktadır ve bu araç bilgilerine göre benzersiz bir bilet oluşturulmaktadır.
</br>Park  metod için URL:http://localhost:8080/garage/park POST işlemi ile yapılmaktadır.
</br> Örnek json
</br>{
</br>"plateNumber": "34-SO-1988",
</br>"color": "Black",
</br>"vehicleType": "CAR"
</br>}
</br>
</br>{
</br>"plateNumber": "34-BO-1987",
</br>"color": "Red",
</br>"vehicleType": "TRUCK"
</br>}

</br>{
</br>"plateNumber": "34-VO-2018",
</br>"color": "Blue",
</br>"vehicleType": "JEEP"
</br>}

</br>Araç ayrılma işlemi için kullanıcıdan araç plaka ve renk bilgisi ile ticket oluşturulur ve ilgili slot kayıtları silinir.
</br> URL:http://localhost:8080/garage/leave


