import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookComponent } from './book/book.component';
import { BookFormComponent } from './forms/book-form/book-form.component';



@NgModule({
  declarations: [BookComponent, BookFormComponent],
  imports: [
    CommonModule
  ]
})
export class BooksTrackingModule { }
