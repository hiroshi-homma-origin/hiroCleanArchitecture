github.dismiss_out_of_range_messages

# Warn when there is a big PR
warn("BIG PR") if git.lines_of_code > 1000

# is_resource_modified = git.modified_files.any? { |file| file.start_with?("app/src/main/res/layout") }
# is_image_in_pr = [".png", ".jpeg", ".jpg", ".gif"].any? { |extension| github.pr_body.include?(extension) }
# if is_resource_modified && !is_image_in_pr
#   message("リソースを更新したら、スクリーンショットとかがあると変更がわかりやすいですね。")
# end

checkstyle_format.base_path = Dir.pwd
failure_or_error_count = 0
lint_path = 'app/build/reports/ktlint-results.xml'
if File.exist?(lint_path)
  checkstyle_format.report lint_path
end

def report(junit, file)
  message = "### Tests: \n\n"

  tests = (junit.failures + junit.errors)
  common_attributes = tests.map { |test| test.attributes.keys }.inject(&:&)
  keys = junit.headers || common_attributes

  attributes = ["File"]
  attributes << keys.map(&:to_s).map(&:capitalize)

  message << attributes.join(' | ') + "|\n"

  lines = ['---']
  lines << keys.map { '---' }

  message << lines.join(' | ') + "|\n"

  tests.each do |test|
    row_values = [file.split('.')[-2]]
    row_values << keys.map { |key| test.attributes[key] }.map { |v| auto_link(v) }
    message << row_values.join(' | ') + "|\n"
  end

  markdown message
end

# Link to test file.
def auto_link(value)
  path = "app/src/test/java/" + value.gsub('.', '/')
  kt_path = path + ".kt"
  java_path = path + ".java"
  if File.exist?(kt_path) && defined?(github)
    github.html_link(kt_path, full_path: false)
  elsif File.exist?(java_path) && defined?(github)
    github.html_link(java_path, full_path: false)
  else
    value
  end
end

# Report test results.
Dir.glob( Dir.pwd + "/app/build/test-results/**/*.xml") { | file |
  junit.parse file
  junit.show_skipped_tests = true
  if junit.failures.nil? or (junit.failures.empty? and junit.errors.empty?)
  else
    fail('Tests have failed, see below for more information.', sticky: false)
    report(junit, file)
    failure_or_error_count += junit.failures.count + junit.errors.count
  end
}

if failure_or_error_count == 0
  message("All tests have passed :100:")
end

lgtm.check_lgtm
