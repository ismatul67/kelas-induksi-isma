Day2

- @requestparam  terdapat parameter value dan default value yang berbeda sifatnya, value memaping variable dengan nama lain... string age pada endpoint akan berubah sesuai isi value pada param... default value untuk set jika param berisi kosong contoh @Requestparam(value ="umur", defaultValue ="15") String age.

- perbedaan request maping sama get maping... get maping bisa langsung memberi tahu method untuk akses adalah get... sedangkan @RequestMaping(method=Get) harus diberi tahu.


Task

Buat aplikasi sederhana post get, bisnis logic jangan taro di controller,..... post maping ada 3 method (1 return ok saja, 2 return json, 3 return eror, response dibalikin lewat service)

post harus request body... get harus ada request param dan path variabel

disarankan membuat package baru, model request dan model response (yang akan dikembalikan oleh response)... response mengembalikan model.

dicontroller return service bukan model secara langsung.

deadline senin jam 12 siang kirim email.