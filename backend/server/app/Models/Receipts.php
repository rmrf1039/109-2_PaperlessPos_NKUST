<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Receipts extends Model
{
    use HasFactory;

    protected $primaryKey = 'number';

		protected $keyType = 'string';
    
    public $incrementing = false;

    protected $fillable = [
			'number',
			'seller_id',
			'detail',
			'uniform_num',
			'carrier',
			'amount',
		];
}
