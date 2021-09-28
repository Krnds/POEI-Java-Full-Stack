import { HttpHeaders } from "@angular/common/http";
import { environment } from "src/environments/environment";

export const HttpOptions = {
     headers : new HttpHeaders({
         'Authorization' : environment.baseUrl
     })
}