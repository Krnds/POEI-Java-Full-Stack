# TODO

- [] Delete Jsoup -> vulnerability in dependency
- [] Pb incorporation modal edit patient vers route /edit/id -> quand click sur bouton edit erreur console JS : `Uncaught TypeError: this._element is undefined`


-> tester ceci :

https://stackoverflow.com/questions/31235677/unable-to-open-another-page-from-a-link-inside-a-modal

https://www.google.com/maps/@48.8102402,2.3128934,3a,21.9y,367.46h,87.04t/data=!3m10!1e1!3m8!1sriD4rp-Bm8XfJKW_OHEisA!2e0!6shttps:%2F%2Fstreetviewpixels-pa.googleapis.com%2Fv1%2Fthumbnail%3Fpanoid%3DriD4rp-Bm8XfJKW_OHEisA%26cb_client%3Dmaps_sv.tactile.gps%26w%3D203%26h%3D100%26yaw%3D348.65866%26pitch%3D0%26thumbfov%3D100!7i16384!8i8192!9m2!1b1!2i17

ou ça avec les ``requêtes AJAX`

https://stackoverflow.com/questions/46342709/how-do-i-open-a-modal-box-with-contents-from-another-page-where-the-url-change

ou avec un script JQuery :

https://www.google.com/maps/@48.8102402,2.3128934,3a,21.9y,367.46h,87.04t/data=!3m10!1e1!3m8!1sriD4rp-Bm8XfJKW_OHEisA!2e0!6shttps:%2F%2Fstreetviewpixels-pa.googleapis.com%2Fv1%2Fthumbnail%3Fpanoid%3DriD4rp-Bm8XfJKW_OHEisA%26cb_client%3Dmaps_sv.tactile.gps%26w%3D203%26h%3D100%26yaw%3D348.65866%26pitch%3D0%26thumbfov%3D100!7i16384!8i8192!9m2!1b1!2i17

- [] convertir format date SQL dans le tableau de la vue des RDV
`th:utext="${dates.format(rdv.dateheure, 'dd/MM/yyyy HH:mm')}`

[] lier les actions delete/edit à des fct JS: th:onclick="|deleteItem('/rdv)

```javascript
function deleteItem(url, id) {
    if (confirm("Etes vous sur ?")) {
        console.log(url + "/delete/" + id);
        fetch(url + "/delete/" + id, {
method:'DELETE',
redirect: 'follow'
        })
        .then
    }
}
```

- changer l'attribut local-datetime en HTML en date + time attr
Dans Rendez-vousRepository mettre 
@Query
SELECT month(dateheuere), year(dateheure), count(*) FROM rdv GROUP BY month(dateheure), year (dateheure), nativeQuery=true;

Javascript date picker :

https://www.jqueryscript.net/blog/best-date-time-picker.html

Essayer ceci aussi :

https://blog.nazrulkabir.com/2018/04/dynamic-modal-with-spring-boot-and-thymeleaf/ +++

IDEE PROJET :

Faire un projet avec authentification JWT, Spring sans spring boot, Mongo DB et Angular 12.
