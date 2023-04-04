use std::cmp::max;
use std::collections::HashMap;

pub struct Solution {


}

impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        // 暴力
        // for i in 0..nums.len() {
        //     let k = i as i32;
        //     let mut j = if k - index_diff < 0 { 0 } else { k - index_diff };
        //     while j < nums.len() as i32 && j <= k + index_diff {
        //         let m = j as usize;
        //         if k != j && (nums[i] - nums[m]).abs() <= value_diff {
        //             return true
        //         }
        //         j += 1;
        //     }
        // }
        // false
        // 桶
        let mut map = HashMap::new();
        let size = (value_diff as i64) + 1;
        for i in 0..nums.len() {
            println!("{:?}", map);

            let num = nums[i] as i64;
            let id = get_id_x(num, size);
            println!("id : {id}");

            if map.contains_key(&id) {
                return true
            }
            if map.contains_key(&(id - 1)) && num - map.get(&(id - 1)).unwrap() <= value_diff as i64 {
                return true
            }
            if map.contains_key(&(id + 1)) && map.get(&(id + 1)).unwrap() - num <= value_diff as i64 {
                return true
            }
            map.insert(id, num);
            if i >= index_diff as usize {
                map.remove(&get_id_x(nums[i - (index_diff as usize)] as i64, size));
            }
        }
        fn get_id_x(num: i64, size: i64) -> i64 {
            return if num >= 0 { num/size } else { ((num + 1) / size) - 1 }
        }

        false
    }
}