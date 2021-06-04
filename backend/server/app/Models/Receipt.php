<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Receipt extends Model
{
	/**public function create($data){
		return Recipt::create($data)
}
**/
	protected $primaryKey = 'receipt_num';
	protected $fillable = [
		'txn_amount',
		'txn_detail',
		'sales_acc',
		'taxID_num',
		'receipt_num',
		'carrier_num',
	];
}
