<?php

namespace App\Http\Controllers\Api;

use App\Models\Receipts;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Response;

class ReceiptController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
  
    public function index(Request $request)
    {
        $limit = $request->limit > 0 ? $request->limit : 0;

        if ($request->carrier) {
            if ($limit == 0){
                $receipts = Receipts::where('carrier', $request->carrier)
                        ->get();
            } else {
                $receipts = Receipts::where('carrier', $request->carrier)
                        ->limit($limit)
                        ->get();
            }

            if (count($receipts) == 0) {
                return response(['code' => 9002, 'error' => 'no record'], 200);
            }

            return response(['receipts' => $receipts], 200);
        }

        return response(['code' => 9001, 'error' => 'missing argument(carrier)'], 200);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $receipt = Receipts::create($request->all());
    	return response($receipt, 200);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Receipts  $receipt
     * @return \Illuminate\Http\Response
     */
    public function show(Receipts $receipt)
    {
	    return response($receipt, 200);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Receipts  $receipt
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Receipts $receipt)
    {
        $receipt->update($request->all());
        return response($receipt, 200);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Receipts  $receipt
     * @return \Illuminate\Http\Response
     */
    public function destroy(Receipts $receipt)
    {
        $receipt->delete();
        return response(null, 204);
    }
}
