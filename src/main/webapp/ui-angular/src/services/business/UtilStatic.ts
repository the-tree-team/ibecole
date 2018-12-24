export class UtilStatic{
  static readonly  API_SOURCE: string = 'http://localhost:8080/';

  static arrayDeleteItem(array, item){
    const index = array.indexOf(item, 0);
    if (index > -1) {
      array.splice(index, 1);
    }
    return array;
  }
}
