import { Injectable } from '@angular/core';
import { MainLayoutComponent } from '../app/layout/main-layout/main-layout.component';

@Injectable({
  providedIn: 'root'
})
export class MainService {
  private mainLayoutRef!: MainLayoutComponent;
  private uiModel : boolean = false; // false = ligth mode, dark mode = true

  constructor() { }


  getUiMode() : boolean {
    return this.uiModel;
  }

  toggleUiModel(){
    this.uiModel = !this.uiModel;
    this.mainLayoutRef.toggleUiModel();
  }


  setMainLayoutRef(mainLayoutRef: MainLayoutComponent){
    this.mainLayoutRef = mainLayoutRef;
  }
  getMainLayoutRef(){
    return this.mainLayoutRef;
  }
}
