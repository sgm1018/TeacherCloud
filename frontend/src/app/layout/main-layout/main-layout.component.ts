import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MainService } from '../../../services/main.service';

@Component({
  selector: 'app-main-layout',
  templateUrl: './main-layout.component.html',
  styleUrl: './main-layout.component.css'
})
export class MainLayoutComponent implements OnInit {
  @ViewChild('mainLayout') mainLayoutElement!: ElementRef;

  constructor(private mainService : MainService) { }

  ngOnInit(): void {
    this.mainService.setMainLayoutRef(this);
  }

  toggleUiModel(){
    this.mainLayoutElement.nativeElement.classList.toggle('dark');
  }


}
